<#list datas as data>
insert into ol_phone_blacklist(phone,prov_code,create_date,phone_desc,add_style,ms_opcode)
values('${data.phone      }', '${data.prov_code  }',to_date('${data.create_date}', 'yyyy-mm-dd hh24:mi:ss') , '${data.phone_desc }','${data.add_style  }', '${data.ms_opcode  }');
</#list>

