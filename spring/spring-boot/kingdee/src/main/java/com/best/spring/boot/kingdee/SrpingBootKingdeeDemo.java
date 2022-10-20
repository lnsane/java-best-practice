package com.best.spring.boot.kingdee;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.best.spring.boot.kingdee.model.req.SubHeadEntity3;
import com.best.spring.boot.kingdee.model.req.SubHeadEntity2;
import com.best.spring.boot.kingdee.model.req.SubHeadEntity;
import com.best.spring.boot.kingdee.model.req.FEntity2;
import com.best.spring.boot.kingdee.model.req.FSubEntity;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.best.spring.boot.kingdee.model.req.FNumber;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.best.spring.boot.kingdee.model.req.OrderRequest;
import com.best.spring.boot.kingdee.model.req.*;
import com.kingdee.bos.webapi.entity.InvokeMode;
import com.kingdee.bos.webapi.entity.QueryParam;
import com.kingdee.bos.webapi.entity.SaveResult;
import com.kingdee.bos.webapi.entity.SuccessEntity;
import com.kingdee.bos.webapi.sdk.K3CloudApi;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author CunLu Wang
 * @since 2022/10/10
 */
@SpringBootApplication
public class SrpingBootKingdeeDemo {

    public static void main(String[] args) {
        SpringApplication.run(SrpingBootKingdeeDemo.class, args);
    }

    @Autowired
    private K3CloudApi k3CloudApi;


    @PostConstruct
    public void test() {
        String s2 = this.queryUserNumber("0003");
        System.out.println(s2);
        String s1 = this.querySosCustomerName("0017C078");
        System.out.println(s1);
        List<String> materList = new ArrayList<>();
        materList.add("160010101001MB1");
        materList.add("160010101001");
        List<MaterialInfo> materials = this.queryMaterialInfo(materList);

        // 同步物料的逻辑
//        this.hello();
        // 获取银行
//        this.h();
        // 同步收款单

        List<ReceiptDetail> receiptDetails = new ArrayList<>();
        ReceiptDetail receiptDetail = new ReceiptDetail();
        receiptDetail.setBankNumber("012-586-2-016233-3-USD");
        receiptDetail.setMoney(new BigDecimal("10"));
        receiptDetails.add(receiptDetail);
        ReceiptDetailResponse c20000001 = this.saveReceipt(0, "C20000001", "200", "012-586-2-016233-3-USD", "200", receiptDetails);

        // 创建销售订单
        List<SaveOrderDetail> saveOrderDetails = new ArrayList<>();
        SaveOrderDetail saveOrderDetail = new SaveOrderDetail();
        saveOrderDetail.setMaterialNumber("160010101001MB1");
        saveOrderDetail.setStock(1);
        saveOrderDetail.setWarehouseNumber("CK200002");
        saveOrderDetails.add(saveOrderDetail);

//        SaveOrderDetail saveOrderDetail2 = new SaveOrderDetail();
//        saveOrderDetail2.setMaterialNumber("160010101001");
//        saveOrderDetail2.setStock(1);
//        saveOrderDetail2.setWarehouseNumber("CK200002");
//        saveOrderDetails.add(saveOrderDetail2);
        String s = this.queryBusinessInfo("0055");
        String deptName = this.queryDeptName("研发部");

        SaveOrderDetailResponse saveOrderDetailResponse = this.saveOrder("C20000001", "200", s, "0055", deptName, LocalDateTime.now(), saveOrderDetails, c20000001.getFBillNo());
        System.out.println(JSONUtil.parse(saveOrderDetailResponse));
        // 创建组装拆卸单
        List<DismantledDetail> dismantledDetails = new ArrayList<>();
        DismantledDetail dismantledDetail = new DismantledDetail();
        dismantledDetail.setMaterialNumber("160010101001");
        dismantledDetail.setStock(1);
        dismantledDetail.setWarehouseNumber("CK200002");
        ArrayList<SubDismantledDetail> subDismantledDetails = new ArrayList<>();
        SubDismantledDetail subDismantledDetail = new SubDismantledDetail();
        subDismantledDetail.setMaterialNumber("160010101001MB1");
        subDismantledDetail.setStock(1);
        subDismantledDetail.setWarehouseNumber("CK200002");
        subDismantledDetails.add(subDismantledDetail);
        dismantledDetail.setSubDismantledDetailList(subDismantledDetails);
        dismantledDetails.add(dismantledDetail);
        JSONArray fSaleOrderEntry = saveOrderDetailResponse.getFSaleOrderEntry();
        List<Integer> fEntryID = fSaleOrderEntry.stream().map(o -> (Integer) ((JSONObject) o).get("FEntryID")).collect(Collectors.toList());
        DismantledDetailResponse dismantledDetailResponse = this.saveDismantled("200", saveOrderDetailResponse.getFid(),fEntryID , dismantledDetails);

        // 组装拆卸单反审
        this.UnAudit("STK_AssembledApp",dismantledDetailResponse.getFBillNo());
////         组装拆卸单 作废
//        this.ExcuteOperation("STK_AssembledApp","Cancel",dismantledDetailResponse.getFBillNo());
//
////          销售订单 关闭
//        this.ExcuteOperation("SAL_SaleOrder","YLBillClose",saveOrderDetailResponse.getFBillNo());




        // 销售出库单
        List<SalesReceipt> salesReceiptList = new ArrayList<>();
        JSONArray fSaleOrderEntry1 = saveOrderDetailResponse.getFSaleOrderEntry();

        SalesReceipt salesReceipt = new SalesReceipt();
        salesReceipt.setMaterialNumber("160010101001MB1");
        salesReceipt.setStock(1);
        salesReceipt.setWarehouseNumber("CK200002");
        Set<Integer> filter = new HashSet<>();
        for (Object o : fSaleOrderEntry1) {
            JSONObject o1 = (JSONObject) o;
            String fMaterialId = ((JSONObject) o1.get("FMaterialId")).get("FNumber").toString();
            Integer fMaterialId1 = (Integer) (o1.get("FEntryID"));
            if (!filter.contains(fMaterialId1)) {
                if ("160010101001MB1".equals(fMaterialId)) {
                    salesReceipt.setChildOrderNumber(Integer.parseInt(o1.get("FEntryID").toString()));
                    filter.add(fMaterialId1);
                }
            }
        }
        salesReceiptList.add(salesReceipt);
        String deptName2 = this.queryDeptName("研发部");
        SalesReceiptResponse salesReceiptResponse = this.saveSalesReceiptRequest("C20000001", "200", "0055", deptName2, salesReceiptList, saveOrderDetailResponse.getFBillNo(), saveOrderDetailResponse.getFid());
        System.out.println(salesReceiptResponse);
        //应收单审核
        this.Audit("AR_receivable", "XSCKD2002210000005");
        // 应收单反审
//        this.UnAudit("AR_receivable","XSCKD2002210000005");
        // 应收单删除
//        this.delete("AR_receivable","XSCKD2002210000005");
        // 销售出库单反审
//        this.UnAudit("SAL_OUTSTOCK","XSCKD2002210000005");
        // 销售出库单 作废
//        this.ExcuteOperation("SAL_OUTSTOCK","Cancel","XSCKD2002210000005");

        // 保存物料
//        this.saveMaterial("组合测试5","ABABABABA005","SM808-191","202");

        // 保存分组
//        this.saveMaterialGroup();

        // 查询业务信息
//        this.queryBusinessInfo("0055");

        // 查询部门名
//        this.queryDeptName("研发部");

    }
    public String queryUserNumber(String businessUserJobNumber) {
        QueryParam queryParam2 = new QueryParam();
        queryParam2.setFormId("BD_Empinfo");
        queryParam2.setFieldKeys("FNumber");
        queryParam2.setFilterString("FNumber  = '" + businessUserJobNumber + "'");
        String execute1 = k3CloudApi.execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{queryParam2.toJson()});
        JSONArray objects = JSONUtil.parseArray(execute1);
        if (objects.isEmpty()) {
            return null;
        }
        JSONArray objects1 = (JSONArray) (objects.get(0));
        return (String) objects1.get(0);
    }
    /**
     * 查询部门编码
     *
     * @param deptName
     */
    private String queryDeptName(String deptName) {
        QueryParam queryParam2 = new QueryParam();
        queryParam2.setFormId("BD_Department");
        queryParam2.setFieldKeys("FNumber");
        queryParam2.setFilterString("fUseOrgId.fNumber = '200' and FName = '" + deptName + "'");
        String execute1 = k3CloudApi.execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{queryParam2.toJson()});
        JSONArray objects = JSONUtil.parseArray(execute1);
        if (objects.isEmpty()) {
            return null;
        }
        JSONArray objects1 = (JSONArray) (objects.get(0));
        return (String) objects1.get(0);
    }

    /**
     * 查询客户名编码
     *
     * @param sosCustomerName 客户名
     */
    private String querySosCustomerName(String sosCustomerName) {
        QueryParam queryParam2 = new QueryParam();
        queryParam2.setFormId("BD_Customer");
        queryParam2.setFieldKeys("FNumber");
        queryParam2.setFilterString("fUseOrgId.fNumber = '200' and FName = '" + sosCustomerName + "'");
        String execute1 = k3CloudApi.execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{queryParam2.toJson()});
        JSONArray objects = JSONUtil.parseArray(execute1);
        if (objects.isEmpty()) {
            return null;
        }
        JSONArray objects1 = (JSONArray) (objects.get(0));
        return (String) objects1.get(0);
    }

    /**
     * 同步物料的逻辑
     */
    public void hello() {
        QueryParam queryParam = new QueryParam();
        queryParam.setFormId("BD_MATERIAL");
        queryParam.setFilterString("BD_MATERIAL");
        // 1 开头 成品 2 开头固定 3开头选配
        queryParam.setFilterString("FMaterialGroup.FNumber in ('160','161','166','169','162','163','171','164','170','167','172','168','165','177','173','174','175','176','260','363','361','360','364','362','365') and fUseOrgId.fNumber = '200' ");
        /**
         * FUseOrgID.FNumber -> 组织码
         * FUseOrgID.FName -> 公司名
         * FNumber -> 固定配件编码
         * FName -> 固定配件名称
         * FSpecification -> 规格型号
         * FMaterialGroup.FNumber -> 分组id
         * FMaterialGroup.FName -> 分类
         * FBaseUnitId.FName -> 单位
         * F_PFAH_Remark1 -> 供应商
         */
        queryParam.setFieldKeys("FUseOrgID.FNumber,FUseOrgID.FName,FNumber,FName,FSpecification,FMaterialGroup.FNumber,FMaterialGroup.FName,FBaseUnitId.FName,F_PFAH_Remark1");
        String execute = k3CloudApi.execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{queryParam.toJson()});
        JSONArray objects = JSONUtil.parseArray(execute);
        for (Object object : objects) {
            JSONArray object1 = (JSONArray) object;
            QueryParam queryParam2 = new QueryParam();
            queryParam2.setFormId("STK_Inventory");
            queryParam2.setFilterString("STK_Inventory");
            queryParam2.setFieldKeys("FMATERIALID.FNumber,FMATERIALID.FName,FStockId.FName,FBaseQty");
            queryParam2.setFilterString("FMATERIALID.FNumber = '" + object1.get(2) + "' and FStockOrgId.FNumber='200' and FOwnerId.FNumber='200'  ");
            /**
             * 同步库存
             * FBaseQty -> 库存
             * FMATERIALID.FNumber 物料编码
             */
            String execute1 = k3CloudApi.execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{queryParam2.toJson()});
            for (Object o : JSONUtil.parseArray(execute1)) {
                JSONArray o1 = (JSONArray) o;
                System.out.println(o1.get(5));
            }
            break;
        }
    }


    public List<MaterialInfo> queryMaterialInfo(List<String> materialNumbers) {
        QueryParam queryParam2 = new QueryParam();
        queryParam2.setFormId("STK_Inventory");
        queryParam2.setFilterString("STK_Inventory");
        queryParam2.setFieldKeys("FMATERIALID.FNumber,FMATERIALID.FName,FStockId.FName,FBaseQty");
        StringBuffer sb = new StringBuffer();
        if (CollUtil.isNotEmpty(materialNumbers)) {
            sb.append(" ( ");
            for (int i = 0; i < materialNumbers.size(); i++) {
                sb.append("'").append(materialNumbers.get(i)).append("'");
                if (materialNumbers.size() - 1 != i) {
                    sb.append(",");
                }
            }
            sb.append(" ) ");
        }
        queryParam2.setFilterString("FMATERIALID.FNumber in " + sb + " and FStockOrgId.FNumber='200' and FOwnerId.FNumber='200'  ");
        /**
         * 查询库存
         * FBaseQty -> 库存
         * FMATERIALID.FNumber 物料编码
         */
        List<MaterialInfo> materialInfos = new ArrayList<>();
        String execute = k3CloudApi.execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{queryParam2.toJson()});
        for (Object o : JSONUtil.parseArray(execute)) {
            JSONArray o1 = (JSONArray) o;
            if (o1.size()>=4) {
                MaterialInfo materialInfo = new MaterialInfo();
                materialInfo.setMaterialNumber(o1.get(0).toString());
                materialInfo.setStock(((BigDecimal) o1.get(3)).intValue());
                materialInfos.add(materialInfo);
            }
        }

        System.out.println(execute);
        return materialInfos;
    }
    /**
     * 物料信息
     */
    @Data
    public static class MaterialInfo {
        /**
         * 物料编码
         */
        private String materialNumber;
        /**
         * 库存
         */
        private Integer stock;
    }



    /**
     * 查询银行
     * @param bankName 银行名
     * @return true false
     */
    public Boolean queryBank(String bankName) {
        QueryParam queryParam = new QueryParam();
        queryParam.setFormId("CN_BANKACNT");
        queryParam.setFilterString("FName = '" + "平安银行深圳旭飞支行4552CNY" + "' and fUseOrgId.fNumber = '200' ");
        queryParam.setFieldKeys("FNumber");
        String execute = k3CloudApi.execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{queryParam.toJson()});
        JSONArray objects = JSONUtil.parseArray(execute);
        if (objects.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 保存和更新收款单
     *
     * @param fid            收款单主键id
     * @param customerNumber 客户编码
     * @param orgId          组织id
     * @param receiptDetails bankNumber 和 money 银行编码
     */
    public ReceiptDetailResponse saveReceipt(Integer fid, String customerNumber, String businessUserJobNumber, String businessUserDepartmentCode, String orgId, List<ReceiptDetail> receiptDetails) {
        ReceiptRequest receiptRequest = new ReceiptRequest();
        if (fid == null) {
            receiptRequest.setFID(0);
        } else {
            receiptRequest.setFID(fid);
        }
        receiptRequest.setFBillTypeID(FNumber2.builder().fNUMBER("SKDLX01_SYS").build());
        receiptRequest.setFDATE(DateUtil.format(LocalDateTime.now(), DatePattern.NORM_DATE_PATTERN));
        receiptRequest.setFCONTACTUNITTYPE("BD_Customer");
        receiptRequest.setFCONTACTUNIT(FNumber.builder().fNumber(customerNumber).build());
        receiptRequest.setFPAYORGID(FNumber.builder().fNumber(orgId).build());
        receiptRequest.setFSETTLEORGID(FNumber.builder().fNumber(orgId).build());
        receiptRequest.setFPAYUNITTYPE("BD_Customer");
        receiptRequest.setFPAYUNIT(FNumber.builder().fNumber(customerNumber).build());
        List<FRECEIVEBILLENTRYItem> freceivebillentry = new ArrayList<>();
        for (ReceiptDetail receiptDetail : receiptDetails) {
            FRECEIVEBILLENTRYItem freceivebillentryItem = new FRECEIVEBILLENTRYItem();
            freceivebillentryItem.setFSETTLETYPEID(FNumber.builder().fNumber("JSFS002").build());
            freceivebillentryItem.setFPURPOSEID(FNumber.builder().fNumber("SFKYT01_SYS").build());
            freceivebillentryItem.setFRECTOTALAMOUNTFOR(receiptDetail.getMoney().doubleValue());
            freceivebillentryItem.setFRECAMOUNTFORE(receiptDetail.getMoney().doubleValue());
            freceivebillentryItem.setFACCOUNTID(FNumber.builder().fNumber(receiptDetail.getBankNumber()).build());
            freceivebillentry.add(freceivebillentryItem);
        }
        receiptRequest.setFRECEIVEBILLENTRY(freceivebillentry);
        KingDeeCustomer<ReceiptRequest> receiptRequestKingDeeCustomer = new KingDeeCustomer<>(Collections.singletonList(receiptRequest));
        receiptRequestKingDeeCustomer.setIsAutoSubmitAndAudit("true");
        try {
            SaveResult result = k3CloudApi.batchSave("AR_RECEIVEBILL", receiptRequestKingDeeCustomer);
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {
                SuccessEntity successEntity = result.getResult().getResponseStatus().getSuccessEntitys().get(0);
                // 主键ID
                String id = successEntity.getId();
                // 编码
                String number = successEntity.getNumber();
                System.out.println(id + "  " + number);
                return ReceiptDetailResponse.builder().fid(Integer.parseInt(id)).fBillNo(number).build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ReceiptDetailResponse saveReceiptSOS(Integer fid, String sosCustomerName,String jobNumber, String deptName,String orgId, List<ReceiptDetail> receiptDetails) {
//        String s = this.querySosCustomerName(sosCustomerName);
//        if (s == null) {
//
//        }
//        return this.saveReceipt(fid,sosCustomerName,jobNumber,);
        return null;
    }

    @Data
    @Builder
    public static class ReceiptDetailResponse {
        // 主ID
        private int fid;
        private String fBillNo;
    }

    @Data
    public static class ReceiptDetail {
        private String bankNumber;
        private BigDecimal money;
    }


    /**
     * {
     * "FormId": "BD_OPERATOR",
     * "FieldKeys": "FBizOrgId.FNumber,FStaffId.FNumber,FNumber,FName",
     * "FilterString": "FBizOrgId.FNumber='200'",
     * "OrderString": "",
     * "TopRowCount": 0,
     * "StartRow": 0,
     * "Limit": 0
     * }
     * 查询业务员信息
     *
     * @param businessUserJobNumber
     */
    public String queryBusinessInfo(String businessUserJobNumber) {
        QueryParam queryParam2 = new QueryParam();
        queryParam2.setFormId("BD_OPERATOR");
        queryParam2.setFieldKeys("FBizOrgId.FNumber,FStaffId.FNumber,FNumber,FName");
        queryParam2.setFilterString("FBizOrgId.FNumber='200' and FStaffId.FNumber = '" + businessUserJobNumber + "'");
        String execute1 = k3CloudApi.execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery", new Object[]{queryParam2.toJson()});
        JSONArray objects = JSONUtil.parseArray(execute1);
        if (objects.isEmpty()) {
            return null;
        }
        JSONArray objects1 = (JSONArray) (objects.get(0));
        return (String) objects1.get(2);
    }

    /**
     * 保存销售订单
     *
     * @param customerNumber             客户编码
     * @param orgId                      组织
     * @param businessUserNumber         业务员编码
     * @param businessUserJobNumber      业务员工号
     * @param businessUserDepartmentCode 业务员部门编码
     * @param createOrder                创建订单时间
     * @param saveOrderDetails           保存订单明细
     * @param FSaleOrderPlan             收款单编号
     */
    public SaveOrderDetailResponse saveOrder(String customerNumber, String orgId, String businessUserNumber, String businessUserJobNumber, String businessUserDepartmentCode, LocalDateTime createOrder, List<SaveOrderDetail> saveOrderDetails, String FSaleOrderPlan) {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setFID(0);
        orderRequest.setFBillTypeID(FNumber2.builder().fNUMBER("XSDD01_SYS").build());
        orderRequest.setFDate(DateUtil.format(LocalDateTime.now(), DatePattern.NORM_DATE_PATTERN));
        orderRequest.setFSaleOrgId(FNumber.builder().fNumber(orgId).build());
        orderRequest.setFCustId(FNumber.builder().fNumber(customerNumber).build());
        // 业务员编码
        orderRequest.setFSalerId(FNumber.builder().fNumber(businessUserNumber).build());
        FSaleOrderFinance fSaleOrderFinance = new FSaleOrderFinance();
        fSaleOrderFinance.setFSettleCurrId(FNumber.builder().fNumber("PRE001").build());
        fSaleOrderFinance.setFExchangeTypeId(FNumber.builder().fNumber("HLTX01_SYS").build());
        List<FSaleOrderEntryItem> fSaleOrderEntryList = new ArrayList<>();
        for (SaveOrderDetail saveOrderDetail : saveOrderDetails) {
            FSaleOrderEntryItem fSaleOrderEntry = new FSaleOrderEntryItem();
            fSaleOrderEntry.setFStockUnitID(FNumber.builder().fNumber("Pcs").build());
            fSaleOrderEntry.setFIsFree(false);
            fSaleOrderEntry.setFMaterialId(FNumber.builder().fNumber(saveOrderDetail.getMaterialNumber()).build());
            fSaleOrderEntry.setFQty(saveOrderDetail.getStock());
            fSaleOrderEntry.setFOwnerTypeId("BD_OwnerOrg");
            fSaleOrderEntry.setF_PFAH_Base(FNumber3.builder().FSTAFFNUMBER(businessUserJobNumber).build());
            fSaleOrderEntry.setF_PFAH_Base1(FNumber.builder().fNumber(businessUserDepartmentCode).build());
            fSaleOrderEntry.setFTaxPrice(100);
            fSaleOrderEntry.setFEntryTaxRate(0);
            fSaleOrderEntry.setFPriceUnitId(FNumber.builder().fNumber("Pcs").build());
            fSaleOrderEntry.setFOwnerId(FNumber.builder().fNumber(orgId).build());
            fSaleOrderEntry.setFDeliveryDate(DateUtil.format(createOrder, DatePattern.NORM_DATE_PATTERN));
            // 短信网关物料编码 160010101001
            fSaleOrderEntry.setFUnitID(FNumber.builder().fNumber("Pcs").build());
            fSaleOrderEntry.setFRowType("Standard");
            fSaleOrderEntry.setFSOStockId(FNumber.builder().fNumber(saveOrderDetail.getWarehouseNumber()).build());
            fSaleOrderEntryList.add(fSaleOrderEntry);
        }
        orderRequest.setFSaleOrderFinance(fSaleOrderFinance);
        orderRequest.setFSaleOrderEntry(fSaleOrderEntryList);
        FSaleOrderPlan fSaleOrderPlan = new FSaleOrderPlan();
        fSaleOrderPlan.setFRelBillNo(FSaleOrderPlan);
        orderRequest.setFSaleOrderPlan(Collections.singletonList(fSaleOrderPlan));
        KingDeeOne<OrderRequest> receiptRequestKingDeeCustomer = new KingDeeOne<>(orderRequest);
        ArrayList<String> list = new ArrayList<>();
        list.add("FID");
        list.add("FBillNo");
        list.add("FSaleOrderEntry.FENTRYID");
        list.add("FSaleOrderEntry.FMaterialId");
        receiptRequestKingDeeCustomer.setNeedReturnFields(list);
        receiptRequestKingDeeCustomer.setIsAutoSubmitAndAudit("true");
        try {
            String json = k3CloudApi.execute("Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Save", new Object[]{"SAL_SaleOrder", receiptRequestKingDeeCustomer.toJson()});
            JSON parse = JSONUtil.parse(json);
            SaveResult result = BeanUtil.toBean(parse, SaveResult.class);
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {
                SuccessEntity successEntity = result.getResult().getResponseStatus().getSuccessEntitys().get(0);
                // 主键ID
                String id = successEntity.getId();
                // 编码
                String number = successEntity.getNumber();
                System.out.println("主键ID = " + id + " 编码 =  " + number);

                Object result2 = parse.getByPath("Result");
                JSONObject result1 = (JSONObject) result2;
                Object needReturnData = result1.get("NeedReturnData");
                JSONArray needReturnData1 = (JSONArray) needReturnData;
                // 子单
                JSONObject jsonObject = (JSONObject) needReturnData1.get(0);
                Object fid = jsonObject.get("FID");
                Object fBillNo = jsonObject.get("FBillNo");
                JSONArray fSaleOrderEntry = (JSONArray) jsonObject.get("FSaleOrderEntry");
//                System.out.println("主键ID = " + fid + " 主编码 =  " + fBillNo + "子主键 = " + list1);
                return SaveOrderDetailResponse.builder().fid((Integer) fid).fBillNo(fBillNo.toString()).FSaleOrderEntry(fSaleOrderEntry).build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Data
    @Builder
    public static class SaveOrderDetailResponse {
        // 主ID
        private int fid;
        private String fBillNo;
        // 子表ID
        private JSONArray FSaleOrderEntry;
    }

    @Data
    public static class SaveOrderDetail {
        /**
         * 物料编码
         */
        private String materialNumber;
        /**
         * 物料需要扣减的库存
         */
        private Integer stock;
        /**
         * 仓库编码
         */
        private String warehouseNumber;
    }


    /**
     * 保存组装拆卸单
     * @param orgId 组织id
     * @param orderNumber 金蝶订单id
     * @param childNumber 子订单金蝶id
     * @param dismantledDetails 组合信息
     * @return DismantledDetailResponse
     */
    public DismantledDetailResponse saveDismantled(String orgId,Integer orderNumber,List<Integer> childNumber, List<DismantledDetail> dismantledDetails) {
        DismantledOrder dismantledOrder = new DismantledOrder();
        dismantledOrder.setFID(0);
        dismantledOrder.setFBillTypeID(FNumber.builder().fNumber("ZZCX01_SYS").build());
        dismantledOrder.setFAffairType("Assembly");
        dismantledOrder.setFDATE(DateUtil.format(LocalDateTime.now(), DatePattern.NORM_DATE_PATTERN));
        dismantledOrder.setFStockOrgId(FNumber.builder().fNumber(orgId).build());
        dismantledOrder.setFOwnerTypeIdHead("BD_OwnerOrg");
        dismantledOrder.setFOwnerIdHead(FNumber.builder().fNumber(orgId).build());
        dismantledOrder.setFSubProOwnTypeIdH("BD_OwnerOrg");
        dismantledOrder.setFSubProOwnerIdH(FNumber.builder().fNumber(orgId).build());
        List<FEntity> fEntityList = new ArrayList<>();
        for (DismantledDetail dismantledDetail : dismantledDetails) {
            FEntity fEntity = new FEntity();
            fEntity.setFMaterialId(FNumber.builder().fNumber(dismantledDetail.getMaterialNumber()).build());
            fEntity.setFUnitID(FNumber.builder().fNumber("Pcs").build());
            fEntity.setFSaleUnitId(FNumber.builder().fNumber("Pcs").build());
            fEntity.setFQty(dismantledDetail.getStock());
            fEntity.setFSaleQty(dismantledDetail.getStock());
            fEntity.setFOwnerTypeID("BD_OwnerOrg");
            fEntity.setFOwnerID(FNumber.builder().fNumber(orgId).build());
            fEntity.setFKeeperTypeID("BD_KeeperOrg");
            fEntity.setFKeeperID(FNumber.builder().fNumber(orgId).build());
            fEntity.setFStockId(FNumber.builder().fNumber(dismantledDetail.getWarehouseNumber()).build());
            List<FEntity_Link> FEntity_Link = new ArrayList<>();
            for (Integer integer : childNumber) {
                FEntity_Link fEntityLink = new FEntity_Link();
                fEntityLink.setFEntity_Link_FSBillId(orderNumber);
                fEntityLink.setFEntity_Link_FSId(integer);
                fEntityLink.setFEntity_Link_FBaseQtyOld(dismantledDetail.getStock());
                fEntityLink.setFEntity_Link_FBaseQty(dismantledDetail.getStock());
                FEntity_Link.add(fEntityLink);
            }
            fEntity.setFEntity_Link(FEntity_Link);
            List<FSubEntity> fSubEntityList = new ArrayList<>();
            for (SubDismantledDetail subDismantledDetail : dismantledDetail.getSubDismantledDetailList()) {
                FSubEntity fSubEntity = new FSubEntity();
                fSubEntity.setFMaterialIDSETY(FNumber.builder().fNumber(subDismantledDetail.getMaterialNumber()).build());
                fSubEntity.setFUnitIDSETY(FNumber.builder().fNumber("Pcs").build());
                fSubEntity.setFQtySETY(subDismantledDetail.getStock());
                fSubEntity.setFStockIDSETY(FNumber.builder().fNumber(subDismantledDetail.getWarehouseNumber()).build());
                fSubEntity.setFBaseUnitIDSETY(FNumber.builder().fNumber("Pcs").build());
                fSubEntity.setFKeeperTypeIDSETY("BD_KeeperOrg");
                fSubEntity.setFKeeperIDSETY(FNumber.builder().fNumber(orgId).build());
                fSubEntity.setFOwnerTypeIDSETY("BD_OwnerOrg");
                fSubEntity.setFOwnerIDSETY(FNumber.builder().fNumber(orgId).build());
                fSubEntityList.add(fSubEntity);
            }
            fEntity.setFSubEntity(fSubEntityList);
            fEntityList.add(fEntity);
        }
        dismantledOrder.setFEntity(fEntityList);
        dismantledOrder.setFDATE(DateUtil.format(LocalDateTime.now(), DatePattern.NORM_DATE_PATTERN));
        dismantledOrder.setFDATE(DateUtil.format(LocalDateTime.now(), DatePattern.NORM_DATE_PATTERN));
        KingDeeOne<DismantledOrder> receiptRequestKingDeeCustomer = new KingDeeOne<>(dismantledOrder);
        receiptRequestKingDeeCustomer.setIsAutoSubmitAndAudit("true");
        try {
            SaveResult result = k3CloudApi.save("STK_AssembledApp", receiptRequestKingDeeCustomer);
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {
                SuccessEntity successEntity = result.getResult().getResponseStatus().getSuccessEntitys().get(0);
                // 主键ID
                String id = successEntity.getId();
                // 编码
                String number = successEntity.getNumber();
                System.out.println("主键ID = " + id + " 编码 =  " + number);
                return DismantledDetailResponse.builder().fBillNo(number).fid(Integer.parseInt(id)).build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Data
    @Builder
    public static class DismantledDetailResponse {
        // 主ID
        private int fid;
        private String fBillNo;
    }


    /**
     * 组织拆卸单 明细
     */
    @Data
    public static class DismantledDetail {
        /**
         * 物料编码
         */
        private String materialNumber;
        /**
         * 物料需要扣减的库存
         */
        private Integer stock;

        /**
         * 仓库编码
         */
        private String warehouseNumber;

        /**
         * 被拆分的子件
         */
        private List<SubDismantledDetail> subDismantledDetailList;
    }

    /**
     * 子类
     */
    @Data
    private static class SubDismantledDetail {
        /**
         * 物料编码
         */
        private String materialNumber;
        /**
         * 物料需要扣减的库存
         */
        private Integer stock;
        /**
         * 仓库编码
         */
        private String warehouseNumber;
    }

    /**
     * 销售出库单
     *
     * @param customerNumber
     * @param orgId
     * @param salesReceiptList
     */
    public SalesReceiptResponse saveSalesReceiptRequest(String customerNumber, String orgId, String businessUserJobNumber, String businessUserDepartmentCode, List<SalesReceipt> salesReceiptList,String orderNumber,Integer orderId) {
        SalesReceiptRequest salesReceiptRequest = new SalesReceiptRequest();
        salesReceiptRequest.setFID(0);
        salesReceiptRequest.setFBillTypeID(FNumber.builder().fNumber("XSCKD01_SYS").build());
        salesReceiptRequest.setFDATE(DateUtil.format(LocalDateTime.now(), DatePattern.NORM_DATE_PATTERN));
        salesReceiptRequest.setFSaleOrgId(FNumber.builder().fNumber(orgId).build());
        salesReceiptRequest.setFCustomerID(FNumber.builder().fNumber(customerNumber).build());
        salesReceiptRequest.setFStockOrgId(FNumber.builder().fNumber(orgId).build());
        salesReceiptRequest.setFOwnerTypeIdHead("BD_OwnerOrg");
        SubHeadEntity subHeadEntity = new SubHeadEntity();
        subHeadEntity.setFSettleCurrId(FNumber.builder().fNumber("RMB").build());
        subHeadEntity.setFExchangeTypeId(FNumber.builder().fNumber("HLTX01_SYS").build());
        subHeadEntity.setFSettleOrgID(FNumber.builder().fNumber(orgId).build());
        subHeadEntity.setFIsIncludedTax(true);
        subHeadEntity.setFIsPriceExcludeTax(true);
        salesReceiptRequest.setSubHeadEntity(new SubHeadEntity());
        List<FEntity2> fEntity2List = new ArrayList<>();
        for (SalesReceipt salesReceipt : salesReceiptList) {
            FEntity2 fEntity2 = new FEntity2();
            fEntity2.setFMaterialId(FNumber.builder().fNumber(salesReceipt.getMaterialNumber()).build());
            fEntity2.setFUnitID(FNumber.builder().fNumber("Pcs").build());
            fEntity2.setFRealQty(salesReceipt.getStock());
            fEntity2.setFIsFree(false);
            fEntity2.setF_PFAH_Base(FNumber3.builder().FSTAFFNUMBER(businessUserJobNumber).build());
            fEntity2.setF_PFAH_Base1(FNumber.builder().fNumber(businessUserDepartmentCode).build());
            fEntity2.setFOwnerID(FNumber.builder().fNumber(orgId).build());
            fEntity2.setFStockID(FNumber.builder().fNumber(salesReceipt.getWarehouseNumber()).build());
            fEntity2.setFOwnerTypeID("BD_OwnerOrg");
            fEntity2.setFSrcBillNo(orderNumber);
            fEntity2.setFSoorDerno(orderNumber);
            fEntity2.setFSoorDerno(orderNumber);
            fEntity2.setFSOEntryId(salesReceipt.getChildOrderNumber());
            List<FEntity_Link2> list = new ArrayList<>();
            FEntity_Link2 fEntity_link2 = new FEntity_Link2();
            fEntity_link2.setFEntity_Link_FSBillId(orderId);
            fEntity_link2.setFEntity_Link_FSId(salesReceipt.getChildOrderNumber());
            fEntity_link2.setFEntity_Link_FBaseUnitQtyOld(salesReceipt.getStock());
            fEntity_link2.setFEntity_Link_FBaseUnitQty(salesReceipt.getStock());
            fEntity_link2.setFEntity_Link_FSALBASEQTYOld(salesReceipt.getStock());
            fEntity_link2.setFEntity_Link_FSALBASEQTY(salesReceipt.getStock());
            list.add(fEntity_link2);
            fEntity2.setFEntity_Link(list);
            fEntity2List.add(fEntity2);
        }
        salesReceiptRequest.setFEntity(fEntity2List);
        KingDeeOne<SalesReceiptRequest> receiptRequestKingDeeCustomer = new KingDeeOne<>(salesReceiptRequest);
        receiptRequestKingDeeCustomer.setIsAutoSubmitAndAudit("true");
        try {
            SaveResult result = k3CloudApi.save("SAL_OUTSTOCK", receiptRequestKingDeeCustomer);
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {
                SuccessEntity successEntity = result.getResult().getResponseStatus().getSuccessEntitys().get(0);
                // 主键ID
                String id = successEntity.getId();
                // 编码
                String number = successEntity.getNumber();
                System.out.println("主键ID = " + id + " 编码 =  " + number);
                return SalesReceiptResponse.builder().fBillNo(number).fid(Integer.parseInt(id)).build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * 销售出库响应
     */
    @Data
    @Builder
    public static class SalesReceiptResponse {
        // 主ID
        private int fid;
        private String fBillNo;
    }

    /**
     * 销售出库
     */
    @Data
    public static class SalesReceipt {
        /**
         * 物料编码
         */
        private String materialNumber;
        /**
         * 物料需要扣减的库存
         */
        private Integer stock;
        /**
         * 仓库编码
         */
        private String warehouseNumber;

        /**
         * 子订单id
         */
        private Integer childOrderNumber;
    }


    /**
     * 保存分组产品
     */
    public void saveMaterialGroup() {
        try {
            String bd_customer = k3CloudApi.groupSave("BD_MATERIAL", "{\"GroupFieldKey\":\"\",\"GroupPkId\":0,\"FParentId\":0,\"FNumber\":\"" + 6 + "\",\"FName\":\" " + "组合产品" + "\",\"FDescription\":\"\"}");
            System.out.println(bd_customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存物料
     *
     * @param materialName   物料名
     * @param materialNumber 物料编码
     * @param FSpecification 规格型号
     */
    public void saveMaterial(String materialName, String materialNumber, String FSpecification, String orgId) {
        Material material = new Material();
        material.setFMATERIALID("0");
        material.setFCreateOrgId(FNumber.builder().fNumber(orgId).build());
        material.setFUseOrgId(FNumber.builder().fNumber(orgId).build());
        material.setFMaterialGroup(FNumber.builder().fNumber("6").build());
        material.setFNumber(materialNumber);
        material.setFName(materialName);
        material.setFSpecification(FSpecification);
        SubHeadEntity2 subHeadEntity2 = new SubHeadEntity2();
        // 外购
        subHeadEntity2.setFErpClsID("1");
        subHeadEntity2.setFCategoryID(FNumber.builder().fNumber("CHLB05_SYS").build());
//        subHeadEntity2.setFTaxRateId(new FNumber());
        subHeadEntity2.setFBaseUnitId(FNumber.builder().fNumber("Pcs").build());
//        subHeadEntity2.setFWEIGHTUNITID(new FNumber());
        SubHeadEntity3 subHeadEntity3 = new SubHeadEntity3();
        subHeadEntity3.setFStoreUnitID(FNumber.builder().fNumber("Pcs").build());
        subHeadEntity3.setFCurrencyId(FNumber.builder().fNumber("CNY").build());
        material.setSubHeadEntity(subHeadEntity2);
        material.setSubHeadEntity1(subHeadEntity3);
        KingDeeOne<Material> receiptRequestKingDeeCustomer = new KingDeeOne<>(material);
        receiptRequestKingDeeCustomer.setIsAutoSubmitAndAudit("true");
        try {
            SaveResult result = k3CloudApi.save("BD_MATERIAL", receiptRequestKingDeeCustomer);
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {
                SuccessEntity successEntity = result.getResult().getResponseStatus().getSuccessEntitys().get(0);
                // 主键ID
                String id = successEntity.getId();
                // 编码
                String number = successEntity.getNumber();
                System.out.println("主键ID = " + id + " 编码 =  " + number);
            }
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {
                SuccessEntity successEntity = result.getResult().getResponseStatus().getSuccessEntitys().get(0);
                String id = successEntity.getId();
                String bd_customer = k3CloudApi.allocate("BD_MATERIAL", "{\"IsAutoSubmitAndAudit\":\"true\",\"PkIds\":\" " + id + "\",\"TOrgIds\":\"100207,100208\"}");
                System.out.println(bd_customer);
            }
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 反审接口
     *
     * @param formId 单据
     * @param number 编码
     */
    public void UnAudit(String formId, String number) {
        String bd_customer = null;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("CreateOrgId", 200);
            jsonObject.set("Numbers", Collections.singletonList(number));
            bd_customer = k3CloudApi.unAudit(formId, jsonObject.toString());
            SaveResult result = BeanUtil.toBean(JSONUtil.parse(bd_customer), SaveResult.class);
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {

            } else {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 审审接口
     *
     * @param formId 单据
     * @param number 编码
     */
    public void Audit(String formId, String number) {
        String bd_customer = null;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("CreateOrgId", 200);
            jsonObject.set("Numbers", Collections.singletonList(number));
            bd_customer = k3CloudApi.unAudit(formId, jsonObject.toString());
            SaveResult result = BeanUtil.toBean(JSONUtil.parse(bd_customer), SaveResult.class);
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {

            } else {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除接口
     *
     * @param formId 单据
     * @param number 编码
     */
    public void delete(String formId, String number) {
        String bd_customer = null;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("CreateOrgId", 200);
            jsonObject.set("Numbers", Collections.singletonList(number));
            bd_customer = k3CloudApi.delete(formId, jsonObject.toString());
            SaveResult result = BeanUtil.toBean(JSONUtil.parse(bd_customer), SaveResult.class);
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {

            } else {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 作废接口
     * @param formId
     * @param operation
     * @param number
     */
    public void ExcuteOperation(String formId, String operation, String number) {
        String bd_customer = null;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("CreateOrgId", 200);
            jsonObject.set("Numbers", Collections.singletonList(number));
            bd_customer = k3CloudApi.excuteOperation(formId, operation, jsonObject.toString());
            SaveResult result = BeanUtil.toBean(JSONUtil.parse(bd_customer), SaveResult.class);
            if (result.getResult().getResponseStatus().getErrors().size() == 0) {

            } else {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
