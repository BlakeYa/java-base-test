package org.example.jvm;

import com.alibaba.fastjson.JSON;

/**
* @Description:    垃圾回收算法：引用计数法
* @Author:         zzq
* @CreateDate:     2020/8/31
*/
public class Test01 {

    public Object instance = null;
    private static final int _1MB = 1024*1024;

    //这个成员属性的唯一意义就是占用内存，一遍在GC日志中看清楚是否被回收过
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        Test01 objA = new Test01();
        Test01 objB = new Test01();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;


        System.gc();
    }

    public static void main(String[] args) {
//        Test01.testGC();

        String aa = "(demandId=2000081415502267084765, demandCode=PPO-jtjcsd-5020000814155022040843, projectCode=20A07CQHC0103835, projectName=中国铁塔重庆分公司合川分公司2020年潼南桂林小沟湾CFRRU（800）新建铁塔项目, prjId=20161246, provinceCode=500000, orgCode=500117, projectManagerUid=liunian, projectManagerName=刘念, purchaseListCode=null, businessCategoryLv1=01, remark=null, consUnitProvinceCode=500000, consUnitOrgCode=500117, consUnitProvinceName=中国铁塔重庆分公司, consUnitOrgName=合川分公司, batchNumber=2000090109420354669752, materialDetail=[WarehouseMaterdetailVO(demandDetailId=2000081415514890412074, materialCode=01010103010203, materialName=三管塔, requestQty=1.0, budgetPrice=61921.34, unit=基, unit_count=0.0, throughWarehouse=N, generalFlag=N, expanFlag=N, bigProjectFlag=N, countryCode=500223, countryName=潼南区, siteCode=500223500000002242, siteName=潼南桂林小沟湾CFRRU（800）, dataType=COMMON, mode=30米风压0.45三层平台每层6付抱杆3米间距(内平台单斜撑))])";
        System.out.println(JSON.toJSONString (aa));

    }

}
