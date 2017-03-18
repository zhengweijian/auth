package org.dimhat.usercenter.service.factory;

import org.dimhat.usercenter.dao.po.DepartmentPO;
import org.dimhat.usercenter.service.dto.DepartmentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/3/18
 */
public class DepartmentFactory {

    /**
     * 初始化po对象
     * @return 部门po
     */
    public static DepartmentPO createPO(){
        DepartmentPO po = new DepartmentPO();
        Date now = new Date();
        po.setGmtCreate(now);
        po.setGmtModified(now);
        return po;
    }

    /**
     * 用po初始化dto对象
     * @param po
     * @return 不包含子部门的对象
     */
    public static DepartmentDTO createDTO(DepartmentPO po){
        if(po==null) return null;
        DepartmentDTO dto = new DepartmentDTO();
        BeanUtils.copyProperties(po,dto);
        return dto;
    }

    /**
     * // FIXME: 2017/3/18 形成环怎么办？
     * 用po初始化dto对象
     * @param po
     * @return 包含子部门的对象
     */
    public static DepartmentDTO createDTORec(DepartmentPO po){
        DepartmentDTO root = createDTO(po);
        if(root==null) return null;

        List<DepartmentPO> subDepartments = po.getSubDepartments();
        if(!CollectionUtils.isEmpty(subDepartments)){
            List<DepartmentDTO> subList = new ArrayList<>();
            for (DepartmentPO subDepartment : subDepartments) {
                subList.add(createDTORec(subDepartment));
            }
            root.setSubDepartments(subList);
        }
        return root;
    }
}
