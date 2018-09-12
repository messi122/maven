package cn.comico.service.impl;


import cn.comico.dto.*;
import cn.comico.feign.AuthServiceClient;
import cn.comico.erp.commons.constant.CacheConstant;
import cn.comico.erp.commons.encode.BPwdEncoderUtil;
import cn.comico.erp.commons.exception.CommonException;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultCode;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.erp.commons.spring.BeanUtils;
import cn.comico.repository.ManagerRepository;
import cn.comico.service.IManagerService;
import cn.comico.set.Manager;
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

@Service
@CacheConfig(cacheNames = CacheConstant.ERP_SET_MANAGER)
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private AuthServiceClient authServiceClient;

    @Override
    @Cacheable
    public List<ManagerDTO> findAll() {
        List<Manager> userList = managerRepository.findAll();
        return BeanUtils.copyList(userList, ManagerDTO.class);
    }

    @Override
    @CacheEvict(allEntries = true)
    public ManagerDTO save(ManagerDTO userDTO) {
        Manager manager = BeanUtils.copyObject(userDTO, Manager.class);
        manager.setPassword(BPwdEncoderUtil.encode(manager.getPassword()));
        Manager m = managerRepository.save(manager);
        return BeanUtils.copyObject(m, ManagerDTO.class);
    }

    @Override
    @Cacheable(key = "#username + T(cn.comico.erp.commons.constant.CacheConstant).SPIDER_CHAR+ #password")
    public ManagerLoginDTO login(String username, String password) {
        Manager manager = managerRepository.findByUsername(username);
        if (null == manager) {
            throw new CommonException(ResultCode.FAIL, "username error");
        }

        if (!BPwdEncoderUtil.mmatches(password, manager.getPassword())) {
            throw new CommonException(ResultCode.FAIL, "password error");
        }

        String header = "Basic " + Base64.getEncoder().encodeToString("user-service:123456".getBytes());
        JWT jwt = authServiceClient.getToken(header, "password", username, password);
        if (null == jwt) {
            throw new CommonException(ResultCode.FAIL, "internal");
        }

        manager.setPassword("");
        ManagerLoginDTO managerLoginDTO = new ManagerLoginDTO();
        managerLoginDTO.setJwt(jwt);
        managerLoginDTO.setManager(BeanUtils.copyObject(manager, ManagerDTO.class));
        return managerLoginDTO;
    }

    @Override
    @Cacheable(key = "#id")
    public ResultResp<ManagerSaveDTO> getOne(Long id) {
        Manager manager = managerRepository.findById(id).orElse(null);
        if (null == manager) {
            return ResultResp.code(ResultCode.OBJECT_NOT_EXISTS).message("object not exists").build();
        }

        ManagerSaveDTO managerSaveDTO = BeanUtils.copyObject(manager, ManagerSaveDTO.class);
        managerSaveDTO.setPassword("");
        StringBuilder stringBuilder = new StringBuilder();
        Optional.ofNullable(manager.getPermissionsList()).orElse(new ArrayList<>())
                .forEach(permission -> {
                    stringBuilder.append(permission.getId());
                    stringBuilder.append(",");
                });
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        managerSaveDTO.setPermissionStr(stringBuilder.toString());
        return ResultResp.code(ResultCode.SUCCESS).data(managerSaveDTO).build();
    }

//    @Override
//    @Cacheable(key = "'listPermission_' + #id")
//    public ResultResp<List<FirstMenuDTO>> listPermission(Long id) {
//        Manager manager = managerRepository.getOne(id);
//        if (null == manager) {
//            return ResultResp.code(ResultCode.FAIL).message("user not exists").build();
//        }
//
//        List<Permission> permissionsList = manager.getPermissionsList();
//        if (null == permissionsList || permissionsList.isEmpty()) {
//            return ResultResp.code(ResultCode.FAIL).message("user not has any permission").build();
//        }
//
//        List<FirstMenuDTO> firstMenuDTOList = new ArrayList<>();
//
//        Map<Long, List<SecondMenuDTO>> secondMenuMap = new TreeMap<>();
//        Map<Long, List<ThirdMenuDTO>> thirdMenuMap = new TreeMap<>();
//        Map<Long, List<String>> permissionMap = new TreeMap<>();
//
//        permissionsList.stream()
//                .forEach(permission -> {
//                    if (Permission.TYPE_MENU == permission.getType() && Permission.MENU_LEVEL_FIRST == permission.getMenuLevel()) {
//                        List<SecondMenuDTO> secondMenuDTOList = new ArrayList<>();
//                        FirstMenuDTO firstMenuDTO = new FirstMenuDTO();
//                        firstMenuDTO.setId(permission.getId());
//                        firstMenuDTO.setName(permission.getName());
//                        firstMenuDTO.setIcon(permission.getIcon());
//                        firstMenuDTO.setChild(secondMenuDTOList);
//                        firstMenuDTOList.add(firstMenuDTO);
//
//                        secondMenuMap.put(permission.getId(), secondMenuDTOList);
//                    } else if (Permission.TYPE_MENU == permission.getType() && Permission.MENU_LEVEL_SECOND == permission.getMenuLevel()) {
//                        List<SecondMenuDTO> secondMenuDTOList = secondMenuMap.get(permission.getFid());
//                        if (null != secondMenuDTOList) {
//                            List<ThirdMenuDTO> thirdMenuDTOList = new ArrayList<>();
//                            SecondMenuDTO secondMenuDTO = new SecondMenuDTO();
//                            secondMenuDTO.setId(permission.getId());
//                            secondMenuDTO.setName(permission.getName());
//                            secondMenuDTO.setIcon(permission.getIcon());
//                            secondMenuDTO.setChild(thirdMenuDTOList);
//                            secondMenuDTOList.add(secondMenuDTO);
//
//                            thirdMenuMap.put(permission.getId(), thirdMenuDTOList);
//                        }
//                    } else if (Permission.TYPE_MENU == permission.getType() && Permission.MENU_LEVEL_THIRD == permission.getMenuLevel()) {
//                        List<ThirdMenuDTO> thirdMenuDTOList = thirdMenuMap.get(permission.getFid());
//                        if (null != thirdMenuDTOList) {
//                            List<String> permissionList = new ArrayList<>();
//                            ThirdMenuDTO thirdMenuDTO = new ThirdMenuDTO();
//                            thirdMenuDTO.setId(permission.getId());
//                            thirdMenuDTO.setName(permission.getName());
//                            thirdMenuDTO.setUrl(permission.getUrl());
//                            thirdMenuDTO.setPermissions(permissionList);
//                            thirdMenuDTOList.add(thirdMenuDTO);
//
//                            permissionMap.put(permission.getId(), permissionList);
//                        }
//                    } else if (Permission.TYPE_PERMISSION == permission.getType()) {
//                        List<String> permissionList = permissionMap.get(permission.getFid());
//                        if (null != permissionList) {
//                            String key = permission.getKey();
//                            permissionList.add(null == key ? "" : key.substring(key.lastIndexOf("_") + 1));
//                        }
//                    }
//                });
//
//        return ResultResp.code(ResultCode.SUCCESS).data(firstMenuDTOList).build();
//    }

    @Override
    public ResultResp<DataGrid<ManagerDTO>> search(String keywords, Long offset, Long pageSize) {
        long count = managerRepository.countIdByNameLike("%" + keywords + "%");
        List<ManagerDTO> managerDTOList = null;
        if (count > 0) {
            List<Manager> managerList = managerRepository.search(keywords, offset, pageSize);
            managerDTOList = Optional.ofNullable(managerList).orElse(new ArrayList<>())
                    .stream()
                    .map(manager -> {
                        manager.setPassword("");
                        return BeanUtils.copyObject(manager, ManagerDTO.class);
                    })
                    .collect(Collectors.toList());
        }
        return ResultResp.code(ResultCode.SUCCESS).data(new DataGrid<>(count, managerDTOList)).build();
    }

    @Cacheable(key = "#root.methodName + T(cn.comico.erp.commons.constant.CacheConstant).SPIDER_CHAR + #id")
    @Override
    public ResultResp<List<MenuDTO>> listPermission(Long id) {
        Manager manager = managerRepository.findById(id).orElse(null);
        if (null == manager) {
            return ResultResp.code(ResultCode.FAIL).message("user not exists").build();
        }

        List<Permission> permissionsList = manager.getPermissionsList();
        if (null == permissionsList || permissionsList.isEmpty()) {
            return ResultResp.code(ResultCode.FAIL).message("user not has any permission").build();
        }

        List<MenuDTO> firstMenuDTOList = new ArrayList<>();

        Map<Long, List<MenuDTO>> secondMenuMap = new TreeMap<>();
        Map<Long, List<MenuDTO>> thirdMenuMap = new TreeMap<>();
        Map<Long, List<String>> permissionMap = new TreeMap<>();

        permissionsList.stream()
                .forEach(permission -> {
                    if (Permission.TYPE_MENU == permission.getType() && Permission.MENU_LEVEL_FIRST == permission.getMenuLevel()) {
                        List<MenuDTO> secondMenuDTOList = new ArrayList<>();
                        MenuDTO menuDTO = new MenuDTO();
                        menuDTO.setName(permission.getKey());
                        menuDTO.setPath(permission.getUrl());
                        menuDTO.setComponent(permission.getComponent());
                        menuDTO.setRedirect(permission.getRedirect());

                        MetaDTO metaDTO = new MetaDTO();
                        metaDTO.setIcon(permission.getIcon());
                        metaDTO.setTitle(permission.getName());
                        menuDTO.setMeta(metaDTO);
                        menuDTO.setChildren(secondMenuDTOList);
                        firstMenuDTOList.add(menuDTO);

                        secondMenuMap.put(permission.getId(), secondMenuDTOList);
                    } else if (Permission.TYPE_MENU == permission.getType() && Permission.MENU_LEVEL_SECOND == permission.getMenuLevel()) {
                        List<MenuDTO> secondMenuDTOList = secondMenuMap.get(permission.getFid());
                        if (null != secondMenuDTOList) {
                            List<MenuDTO> thirdMenuDTOList = new ArrayList<>();
                            MenuDTO secondMenuDTO = new MenuDTO();
                            secondMenuDTO.setName(permission.getKey());
                            secondMenuDTO.setPath(permission.getUrl());
                            secondMenuDTO.setComponent(permission.getComponent());
                            secondMenuDTO.setRedirect(permission.getRedirect());

                            MetaDTO metaDTO = new MetaDTO();
                            metaDTO.setTitle(permission.getName());
                            metaDTO.setIcon(permission.getIcon());
                            secondMenuDTO.setMeta(metaDTO);
                            secondMenuDTO.setChildren(thirdMenuDTOList);
                            secondMenuDTOList.add(secondMenuDTO);

                            thirdMenuMap.put(permission.getId(), thirdMenuDTOList);
                        }
                    } else if (Permission.TYPE_MENU == permission.getType() && Permission.MENU_LEVEL_THIRD == permission.getMenuLevel()) {
                        List<MenuDTO> thirdMenuDTOList = thirdMenuMap.get(permission.getFid());
                        if (null != thirdMenuDTOList) {
                            List<String> permissionList = new ArrayList<>();
                            MenuDTO thirdMenuDTO = new MenuDTO();
                            thirdMenuDTO.setName(permission.getKey());
                            thirdMenuDTO.setPath(permission.getUrl());
                            thirdMenuDTO.setComponent(permission.getComponent());
                            thirdMenuDTO.setRedirect(permission.getRedirect());

                            MetaDTO metaDTO = new MetaDTO();
                            metaDTO.setIcon(permission.getIcon());
                            metaDTO.setTitle(permission.getName());
                            metaDTO.setPermission(permissionList);
                            thirdMenuDTO.setMeta(metaDTO);
                            thirdMenuDTOList.add(thirdMenuDTO);

                            permissionMap.put(permission.getId(), permissionList);
                        }
                    } else if (Permission.TYPE_PERMISSION == permission.getType()) {
                        List<String> permissionList = permissionMap.get(permission.getFid());
                        if (null != permissionList) {
                            String key = permission.getKey();
                            permissionList.add(null == key ? "" : key.substring(key.lastIndexOf("_") + 1));
                        }
                    }
                });

        return ResultResp.code(ResultCode.SUCCESS).data(firstMenuDTOList).build();
    }

    @Override
    public ManagerLoginDTO refreshToken(String refreshToken) {


        String header = "Basic " + Base64.getEncoder().encodeToString("user-service:123456".getBytes());
        JWT jwt = authServiceClient.refreshToken(header, "refresh_token", refreshToken);
        if (null == jwt) {
            throw new CommonException(ResultCode.FAIL, "internal");
        }

        ManagerLoginDTO managerLoginDTO = new ManagerLoginDTO();
        managerLoginDTO.setJwt(jwt);
        return managerLoginDTO;
    }

    @Override
    public ResultResp<DataGrid<List<ManagerDTO>>> findManagerList(Integer type, Long channelId, String keywords, int offset, int pageSize) {
//        Page<ManagerDTO> page = managerRepository.findManagerList(type, channelId, keywords
//                , PageRequest.of(offset / pageSize, pageSize));
//        return ResultResp.code(ResultCode.SUCCESS).data(new DataGrid<>(page.getTotalElements(), page.getContent())).build();
        long count = managerRepository.findManagerListCount(type, channelId, keywords);
        List<ManagerDTO> managerDTOList = new ArrayList<>();
        if (count > 0) {
            managerDTOList = managerRepository.findManagerList(type, channelId, keywords, offset, pageSize);
        }
        return ResultResp.code(ResultCode.SUCCESS).data(managerDTOList).build();
    }

    @CacheEvict(allEntries = true)
    @Transactional
    @Override
    public ResultResp saveManager(ManagerSaveDTO managerSaveDTO) {
        Manager manager = BeanUtils.copyObject(managerSaveDTO, Manager.class);
        manager.setPassword(BPwdEncoderUtil.encode(managerSaveDTO.getPassword()));
        manager.setCreateDate(new Date());

        Manager m1 = managerRepository.save(manager);

        if (!StringUtils.isEmpty(managerSaveDTO.getPermissionStr())) {
            List<Long> idList = Arrays.asList(managerSaveDTO.getPermissionStr().split(","))
                    .stream()
                    .map(idStr -> {
                        return Long.valueOf(idStr);
                    })
                    .collect(Collectors.toList());

            managerRepository.batchSaveManagerPermission(m1.getId(), idList);
        }

        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    @CacheEvict(allEntries = true)
    @Override
    public ResultResp updateStatus(Long id, Integer status) {
        Manager manager = managerRepository.findById(id).orElse(null);
        if (null == manager) {
            return ResultResp.code(ResultCode.OBJECT_NOT_EXISTS).build();
        }

        manager.setStatus(status);
        managerRepository.saveAndFlush(manager);
        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    @CacheEvict(allEntries = true)
    @Transactional
    @Override
    public ResultResp deleteManager(Long id) {
        managerRepository.deleteById(id);
        managerRepository.deleteManagerPermission(id);
        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    @CacheEvict(allEntries = true)
    @Transactional
    @Override
    public ResultResp updateManager(ManagerSaveDTO managerSaveDTO) {
        Manager manager = managerRepository.findById(managerSaveDTO.getId()).orElse(null);
        if (null == manager) {
            return ResultResp.code(ResultCode.OBJECT_NOT_EXISTS).build();
        }

        manager.setChannelId(managerSaveDTO.getChannelId());
        manager.setPassword(StringUtils.isEmpty(managerSaveDTO.getPassword()) ? manager.getPassword() : BPwdEncoderUtil.encode(managerSaveDTO.getPassword()));
        manager.setGroup(managerSaveDTO.getGroup());
        manager.setLevel(managerSaveDTO.getLevel());
        manager.setPhone(managerSaveDTO.getPhone());
        manager.setEmail(managerSaveDTO.getEmail());
        manager.setShopId(managerSaveDTO.getShopId());
        manager.setUsername(managerSaveDTO.getUsername());
        manager.setName(managerSaveDTO.getName());

        managerRepository.saveAndFlush(manager);
        managerRepository.deleteManagerPermission(managerSaveDTO.getId());

        List<Long> idList =Optional.ofNullable(Arrays.asList(managerSaveDTO.getPermissionStr().split(",")))
                .orElse(new ArrayList<>())
                .stream()
                .map(idStr -> {
                    return Long.valueOf(idStr);
                })
                .collect(Collectors.toList());
        managerRepository.batchSaveManagerPermission(managerSaveDTO.getId(), idList);
        return ResultResp.code(ResultCode.SUCCESS).build();
    }
}
