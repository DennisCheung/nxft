--
-- 医疗保险方式表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_medinsu_meth;
create Table  fxp.p_medinsu_meth (
-- +-----------------------------+--------------+-----------+		
   fmedinsu_meth_id              varchar2(32)   not null,   -- 医疗保险方式id
   fmedinsu_meth_code            varchar2(30)   not null,   -- 医疗保险方式代码
   fmedinsu_meth_gbcode          varchar2(32),              -- 国标代码   
   fmedinsu_meth_name            varchar2(30)   not null,   -- 医疗保险方式  名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入备注 
   --  
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fmedinsu_meth_desc            varchar2(256),             -- 备注
   --                       
   -- 日志                  
   --                       
   fversion                      number(6)                   -- 版本号
                                 default 0       not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_medinsu_meth primary key (fmedinsu_meth_id),
   constraint uk_p_medinsu_meth_code unique (fmedinsu_meth_code)
   );

--
-- 同义词
--

--
-- 外部键约束
--
--
-- 授权
--

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '职工医保', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '居民医保', 'N', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '公费医疗', 'N', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '新农合', 'N', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '自费', 'N', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '其他', 'Y', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;

