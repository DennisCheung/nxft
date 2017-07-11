--
-- 客户亲朋关系表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_person_relation;
create Table  fxp.p_person_relation (
-- +-----------------------------+--------------+-----------+		
   fperson_relation_id           varchar2(32)   not null,   -- 联系人关系ID
   fperson_relation_code         varchar2(8)    not null,   -- 联系人关系代码
   fperson_relation_gbcode       varchar2(32),              -- 国标代码
   fperson_relation_name         varchar2(40)   not null,   -- 联系人关系名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fperson_relation_desc         varchar2(256),             -- 备注
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
   constraint pk_p_person_relation primary key (fperson_relation_id),
   constraint uk_p_person_relation_code unique (fperson_relation_code)
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

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '夫妻', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '子女', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '儿媳', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '女婿', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '外甥', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', '侄子', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 孙辈

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('10', '10', '10', '孙子', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('11', '11', '11', '孙女', 'Y', 11, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- 其他

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('20', '20', '20', '朋友', 'Y', 20, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('21', '21', '21', '邻居', 'Y', 21, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('22', '22', '22', '表亲', 'Y', 22, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('23', '23', '23', '战友', 'Y', 23, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('24', '24', '24', '同学', 'Y', 24, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('25', '25', '25', '恋人', 'Y', 25, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '其他', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;