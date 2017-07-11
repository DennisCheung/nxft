--
-- 文化程度
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_edu_degree;
create table fxp.p_edu_degree (
-- +-----------------------------+--------------+-----------+
   fedu_degree_id                varchar2(32)   not null,   -- 文化程度ID
   fedu_degree_code              varchar2(8)    not null,   -- 文化程度代码
   fedu_degree_gbcode            varchar2(32),              -- 国标代码
   fedu_degree_name              varchar2(40)   not null,   -- 文化程度名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fedu_degree_desc              varchar2(256),             -- 备注
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
   constraint pk_p_edu_degree primary key (fedu_degree_id),
   constraint uk_p_edu_degree_code unique (fedu_degree_code)
   );

--
-- 同义词
--

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '高中', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '中专', 'Y', 2, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '大专', 'Y', 3, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '本科', 'Y', 4, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '硕士', 'Y', 5, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', '博士', 'Y', 6, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('07', '07', '07', '初中', 'Y', 7, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('08', '08', '08', '小学', 'Y', 8, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '文盲与半文盲', 'Y', 9, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

commit;
