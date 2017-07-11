--
-- 身份证件类别表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_id_type;
create Table fxp.p_id_type (
-- +-----------------------------+--------------+-----------+		
   fidtype_id                    varchar2(32)   not null,   -- ID
   fidtype_code                  varchar2(8)    not null,   -- 代码
   fidtype_gbcode                varchar2(32),              -- 国标代码
   fidtype_name                  varchar2(40)   not null,   -- 名称
   --
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fidtype_desc                  varchar2(256),             -- 备注      
   --                       
   -- 日志                  
   --                       
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date default sysdate not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date default sysdate not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date default sysdate not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_id_type primary key (fidtype_Id),
   constraint uk_p_id_type_code unique (fidtype_Code)
   );

--
-- 同义词
--

insert into p_id_type (FIDTYPE_ID, FIDTYPE_CODE, FIDTYPE_GBCODE, FIDTYPE_NAME, FISAVAILABLE, FORDERNUM, FIDTYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', '二代身份证', 'Y', 1.00, '', 0, 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'));

insert into p_id_type (FIDTYPE_ID, FIDTYPE_CODE, FIDTYPE_GBCODE, FIDTYPE_NAME, FISAVAILABLE, FORDERNUM, FIDTYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '港澳通行证', 'Y', 1.00, '', 0, 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'));

insert into p_id_type (FIDTYPE_ID, FIDTYPE_CODE, FIDTYPE_GBCODE, FIDTYPE_NAME, FISAVAILABLE, FORDERNUM, FIDTYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', '台胞证证', 'Y', 1.00, '', 0, 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'));

commit; 
