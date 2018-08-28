package cn.comico.service.impl;


import cn.comico.dto.*;
import cn.comico.erp.commons.result.ResultCode;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.repository.PermissionRepository;
import cn.comico.service.IPermissionService;
import cn.comico.set.Permission;
import cn.comico.supply.dto.*;
import cn.comico.supply.erp.commons.result.ResultCode;
import cn.comico.supply.erp.commons.result.ResultResp;
import cn.comico.supply.service.IPermissionService;
import cn.comico.supply.set.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionServiceImpl
 * @Description TODO
 * @date 2018/6/25 14:44
 **/
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public ResultResp<List<PermissionDTO>> findPermission(int type, int level, int menuLevl) {
        List<PermissionDTO> permissionDTOList = permissionRepository.findPermission(type, level, menuLevl);
        return ResultResp.code(ResultCode.SUCCESS).data(permissionDTOList).build();
    }

    @Override
    public ResultResp<List<PermissionDetailDTO>> getPermissionDetail(Long id, int type, int level, int menuLevel) {
        List<Object[]> list = permissionRepository.getPermissionDetail(id, type, level, menuLevel);
        List<PermissionDetailDTO> permissionDetailDTOList = new ArrayList<>();
        Map<Long, List<PermissionThirdDTO>> permissionThirdDTOMap = new HashMap<>();

        Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream()
                .forEach(obj -> {
                    Long fid = (Long) obj[0];
                    String fname = (String) obj[1];
                    Long childId = (Long) obj[2];
                    String name = (String) obj[3];

                    //判断是否有父id
                    List<PermissionThirdDTO> permissionThirdDTOList = null;
                    if (permissionThirdDTOMap.containsKey(fid)) {
                        permissionThirdDTOList = permissionThirdDTOMap.get(fid);
                        PermissionThirdDTO permissionThirdDTO = new PermissionThirdDTO();
                        permissionThirdDTO.setId(childId);
                        permissionThirdDTO.setName(name);
                        permissionThirdDTO.setPermissionList(getPermission(childId));
                        permissionThirdDTOList.add(permissionThirdDTO);
                    } else {
                        permissionThirdDTOList = new ArrayList<>();
                        PermissionThirdDTO permissionThirdDTO = new PermissionThirdDTO();
                        permissionThirdDTO.setId(childId);
                        permissionThirdDTO.setName(name);
                        permissionThirdDTO.setPermissionList(getPermission(childId));
                        permissionThirdDTOList.add(permissionThirdDTO);

                        PermissionDetailDTO permissionDetailDTO = new PermissionDetailDTO();
                        permissionDetailDTO.setId(fid);
                        permissionDetailDTO.setName(fname);
                        permissionDetailDTO.setPermissionThirdList(permissionThirdDTOList);

                        permissionDetailDTOList.add(permissionDetailDTO);

                    }
                    permissionThirdDTOMap.put(fid, permissionThirdDTOList);

                });

        return ResultResp.code(ResultCode.SUCCESS).data(permissionDetailDTOList).build();
    }

    @Transactional
    @Override
    public ResultResp updatePermission(List<ManagerPermissionDTO> list) {
        Optional.ofNullable(list).orElse(new ArrayList<>())
                .forEach(managerPermissionDTO -> {
                    if (ManagerPermissionDTO.ADD == managerPermissionDTO.getType()) {
                        long count = permissionRepository.findManagerPermissionListCount(managerPermissionDTO.getPermissionId(), managerPermissionDTO.getUserId());
                        if (count == 0) {
                            permissionRepository.saveOrUpdateManagerPermission(managerPermissionDTO.getPermissionId(), managerPermissionDTO.getUserId());
                        }
                    } else if (ManagerPermissionDTO.DEL == managerPermissionDTO.getType()) {
                        permissionRepository.deleteManagerPermission(managerPermissionDTO.getPermissionId(), managerPermissionDTO.getUserId());

                        deleteParentPermission(managerPermissionDTO.getUserId(), managerPermissionDTO.getPermissionId());
                    }
                });
        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    @Override
    public ResultResp<List<PermissionFirstDTO>> findPermissionByType(Integer type) {
        List<PermissionFirstDTO> permissionFirstDTOList = new ArrayList<>();
        List<Permission> permissionList = permissionRepository.findPermissionByLevel(type);

        Map<Long, List<PermissionDetailDTO>> permissionDetailDTOMap = new HashMap<>();
        Map<Long, List<PermissionThirdDTO>> permissionThirdDTOMap = new HashMap<>();
        Map<Long, List<PermissionListDTO>> permissionListDTOMap = new HashMap<>();
        Optional.ofNullable(permissionList).orElse(new ArrayList<>())
                .forEach(permission -> {
                    if (Permission.TYPE_MENU == permission.getType()
                            && Permission.MENU_LEVEL_FIRST == permission.getMenuLevel()) {
                        PermissionFirstDTO permissionFirstDTO = new PermissionFirstDTO();
                        List<PermissionDetailDTO> permissionDetailDTOList = new ArrayList<>();

                        permissionFirstDTO.setId(permission.getId());
                        permissionFirstDTO.setName(permission.getName());
                        permissionFirstDTO.setIcon(permission.getIcon());
                        permissionFirstDTO.setChildren(permissionDetailDTOList);

                        permissionFirstDTOList.add(permissionFirstDTO);
                        permissionDetailDTOMap.put(permission.getId(), permissionDetailDTOList);
                    } else if (Permission.TYPE_MENU == permission.getType()
                            && Permission.MENU_LEVEL_SECOND == permission.getMenuLevel()) {
                        if (permissionDetailDTOMap.containsKey(permission.getFid())) {
                            List<PermissionDetailDTO> permissionDetailDTOList = permissionDetailDTOMap.get(permission.getFid());

                            List<PermissionThirdDTO> permissionThirdDTOList = new ArrayList<>();
                            PermissionDetailDTO permissionDetailDTO = new PermissionDetailDTO();
                            permissionDetailDTO.setId(permission.getId());
                            permissionDetailDTO.setName(permission.getName());
                            permissionDetailDTO.setPermissionThirdList(permissionThirdDTOList);

                            permissionDetailDTOList.add(permissionDetailDTO);
                            permissionThirdDTOMap.put(permission.getId(), permissionThirdDTOList);
                        }
                    } else if (Permission.TYPE_MENU == permission.getType()
                            && Permission.MENU_LEVEL_THIRD == permission.getMenuLevel()) {
                        if (permissionThirdDTOMap.containsKey(permission.getFid())) {
                            List<PermissionThirdDTO> permissionThirdDTOList = permissionThirdDTOMap.get(permission.getFid());
                            List<PermissionListDTO> permissionListDTOList = new ArrayList<>();

                            PermissionThirdDTO permissionThirdDTO = new PermissionThirdDTO();
                            permissionThirdDTO.setId(permission.getId());
                            permissionThirdDTO.setName(permission.getName());
                            permissionThirdDTO.setPermissionList(permissionListDTOList);

                            permissionThirdDTOList.add(permissionThirdDTO);
                            permissionListDTOMap.put(permission.getId(), permissionListDTOList);
                        }
                    } else if (Permission.TYPE_PERMISSION == permission.getType()) {
                        if (permissionListDTOMap.containsKey(permission.getFid())) {
                            List<PermissionListDTO> permissionListDTOList = permissionListDTOMap.get(permission.getFid());

                            PermissionListDTO permissionListDTO = new PermissionListDTO();
                            permissionListDTO.setPermissionId(permission.getId());
                            permissionListDTO.setManagerList(null);         //不查管理员
                            String key = permission.getKey();
                            permissionListDTO.setPermission(key.substring(key.lastIndexOf("_") + 1));

                            permissionListDTOList.add(permissionListDTO);
                        }
                    }
                });
        return ResultResp.code(ResultCode.SUCCESS).data(permissionFirstDTOList).build();
    }

    private void deleteParentPermission(Long userId, Long permissionId) {
        long fid = permissionId / 100;
        if (fid <= 0) {
            return;
        }

        Long count = permissionRepository.countManagerPermissionByFid(userId, fid);
        if (0 == count) {
            //删除父权限
            permissionRepository.deleteManagerPermission(fid, userId);
            //递归
            deleteParentPermission(userId, fid);
        }
    }

    private List<PermissionListDTO> getPermission(Long fid) {
        List<Object[]> list = permissionRepository.getPermission(fid);
        List<PermissionListDTO> PermissionListDTOList = new ArrayList<>();
        Map<String, List<PermissionManagerDTO>> permissionManagerMap = new HashMap<>();
        Optional.ofNullable(list).orElse(new ArrayList<>())
            .stream()
            .forEach(obj -> {
                Long ffid = (Long) obj[0];
                String key = (String) obj[1];
                Long userId = (Long) obj[2];
                String name = (String) obj[3];

                String permissionStr = key.substring(key.lastIndexOf("_") + 1);
                if (permissionManagerMap.containsKey(permissionStr)) {
                    List<PermissionManagerDTO> permissionManagerDTOList = permissionManagerMap.get(permissionStr);
                    PermissionManagerDTO permissionManagerDTO = new PermissionManagerDTO();
                    permissionManagerDTO.setUserId(userId);
                    permissionManagerDTO.setUsername(name);

                    permissionManagerDTOList.add(permissionManagerDTO);
                } else {
                    List<PermissionManagerDTO> permissionManagerDTOList = new ArrayList<>();

                    PermissionManagerDTO permissionManagerDTO = new PermissionManagerDTO();
                    permissionManagerDTO.setUserId(userId);
                    permissionManagerDTO.setUsername(name);
                    permissionManagerDTOList.add(permissionManagerDTO);

                    PermissionListDTO permissionListDTO = new PermissionListDTO();
                    permissionListDTO.setPermissionId(ffid);
                    permissionListDTO.setPermission(permissionStr);
                    permissionListDTO.setManagerList(permissionManagerDTOList);
                    PermissionListDTOList.add(permissionListDTO);

                    permissionManagerMap.put(permissionStr, permissionManagerDTOList);
                }

            });

        return PermissionListDTOList;
    }

}
