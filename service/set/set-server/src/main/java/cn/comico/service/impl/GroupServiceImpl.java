package cn.comico.service.impl;


import cn.comico.dto.GroupDTO;
import cn.comico.erp.commons.constant.CacheConstant;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultCode;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.erp.commons.spring.BeanUtils;
import cn.comico.repository.GroupRepository;
import cn.comico.service.IGroupService;
import cn.comico.set.Group;
import cn.comico.set.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName GroupServiceImpl
 * @Description TODO
 * @date 2018/6/28 17:53
 **/
@CacheConfig(cacheNames = CacheConstant.ERP_SET_GROUP)
@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public ResultResp<DataGrid<GroupDTO>> findGroupList(Integer type, int offset, int pageSize) {
        long count = groupRepository.findGroupListCount(type);
        List<GroupDTO> list = new ArrayList<>();
        if (count > 0) {
            list = groupRepository.findGroupList(type, offset, pageSize);
        }
        return ResultResp.code(ResultCode.SUCCESS).data(list).build();
    }


    @CacheEvict(allEntries = true)
    @Transactional
    @Override
    public ResultResp saveGroup(GroupDTO groupDTO) {
        Group group = new Group();
        group.setName(groupDTO.getName());
        group.setRemark(groupDTO.getRemark());
        group.setStatus(groupDTO.getStatus());
        group.setType(groupDTO.getType());
        group.setCreateDate(new Date());

        Group g1 = groupRepository.save(group);

        if (!StringUtils.isEmpty(groupDTO.getPermissionStr())) {
            List<Long> idList = Arrays.asList(groupDTO.getPermissionStr().split(","))
                    .stream()
                    .map(idStr -> {
                        return Long.valueOf(idStr);
                    })
                    .collect(Collectors.toList());
            groupRepository.batchSaveGroup(g1.getId(), idList);
        }

        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    @Cacheable(key = "#id")
    @Override
    public ResultResp<GroupDTO> getGroup(Long id) {
        Optional<Group> optional = groupRepository.findById(id);

         if (!optional.isPresent()) {
            return ResultResp.code(ResultCode.FAIL).build();
        }

        GroupDTO groupDTO = BeanUtils.copyObject(optional.get(), GroupDTO.class);
        StringBuilder stringBuilder = new StringBuilder();
        Optional.ofNullable(optional.get().getPermissionsList()).orElse(new ArrayList<>())
                .forEach(permission -> {
                    if (Permission.TYPE_PERMISSION == permission.getType()) {
                        stringBuilder.append(permission.getId());
                        stringBuilder.append(",");
                    }
                });
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        groupDTO.setPermissionStr(stringBuilder.toString());
        return ResultResp.code(ResultCode.SUCCESS).data(groupDTO).build();
    }

    @CacheEvict(allEntries = true)
    @Transactional
    @Override
    public ResultResp updateGroup(GroupDTO groupDTO) {
        Group group = groupRepository.findById(groupDTO.getId()).orElse(null);
        if (null == group) {
            return ResultResp.code(ResultCode.OBJECT_NOT_EXISTS).build();
        }

        group.setName(groupDTO.getName());
        group.setType(groupDTO.getType());
        group.setRemark(groupDTO.getRemark());

        groupRepository.saveAndFlush(group);
        groupRepository.deleteGroupPermission(groupDTO.getId());
        if (!StringUtils.isEmpty(groupDTO.getPermissionStr())) {
            List<Long> idList = Arrays.asList(groupDTO.getPermissionStr().split(","))
                    .stream()
                    .map(idStr -> {
                        return Long.valueOf(idStr);
                    })
                    .collect(Collectors.toList());
            groupRepository.batchSaveGroup(groupDTO.getId(), idList);
        }

        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    @CacheEvict(allEntries = true)
    @Override
    public ResultResp updateStatus(Long id, Integer status) {
        Group group = groupRepository.findById(id).orElse(null);
        if (null == group) {
            return ResultResp.code(ResultCode.OBJECT_NOT_EXISTS).build();
        }

        group.setStatus(status);
        groupRepository.saveAndFlush(group);
        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    @CacheEvict(allEntries = true)
    @Transactional
    @Override
    public ResultResp deleteGroup(Long id) {
        groupRepository.deleteById(id);
        groupRepository.deleteGroupPermission(id);
        return ResultResp.code(ResultCode.SUCCESS).build();
    }
}
