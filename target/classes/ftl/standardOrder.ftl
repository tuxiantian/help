insert into db_ap_rgsh_standard_order(LOGID,BUSI_TYPE,CREATE_DATE)values
<#list datas as data>
('${data.logid}','16','${data.createDate}')<#if data_has_next>,<#else>;</#if>
</#list>
insert into db_ap_rgsh_standard_order_idcard_${yyyyMM}(LOGID,CUST_CERT_NO)values
<#list datas as data>
('${data.logid}','412829199109093214')<#if data_has_next>,<#else>;</#if>
</#list>
insert into db_ap_rgsh_standard_order_addition_${yyyyMM}(LOGID,PROPERTY_NAME,PROPERTY_VALUE)values
<#list datas as data>
('${data.logid}','frontImg','/data/1.jpg'),
('${data.logid}','sim','145289109093214')<#if data_has_next>,<#else>;</#if>
</#list>