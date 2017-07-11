--
-- 职业表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_occupation;
create table  fxp.p_occupation (
-- +-----------------------------+--------------+-----------+
   foccupation_id                varchar2(32)   not null,   -- 职业ID
   foccupation_code              varchar2(30)   not null,   -- 职业代码
   foccupation_gbcode            varchar2(32),              -- 国标代码
   foccupation_name              varchar2(40)   not null,   -- 职业名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入备注
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   foccupation_desc              varchar2(256),             -- 备注
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
   constraint pk_p_occupation primary key (foccupation_id),
   constraint uk_p_occupation_code unique (foccupation_code)
);

--
-- 同义词
--
-- 职业国标非常难填，参照《中国人民人寿保险股份有限公司职业分类表》

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00', '00', '00', '一般行政人员','N', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', '农牧业','N', 'Y', 2, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '渔业','N', 'Y', 3, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', '木材森林业','N', 'Y', 4, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', '矿业采石业','N', 'Y', 5, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('05', '05', '05', '交通运输业','N', 'Y', 6, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('06', '06', '06', '餐旅业','N', 'Y', 7, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('07', '07', '07', '建筑工程业','N', 'Y', 8, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('08', '08', '08', '制造业','N', 'Y', 9, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('09', '09', '09', '新闻广告','N', 'Y', 10, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10', '10', '10', '卫生保健', 'N','Y', 11, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('11', '11', '11', '影视娱乐业','N', 'Y', 12, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('12', '12', '12', '科教文化','N', 'Y', 13, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('13', '13', '13', '宗教','N', 'Y', 14, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('14', '14', '14', '公共事业服务','N', 'Y', 15, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('15', '15', '15', '商业','N', 'Y', 16, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('16', '16', '16', '金融保险业','N', 'Y', 17, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('17', '17', '17', '服务业','N', 'Y', 18, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('18', '18', '18', '家庭管理','N', 'Y', 19, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('19', '19', '19', '治安人员军人','N', 'Y', 20, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('20', '20', '20', '体育','N', 'Y', 21, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('21', '21', '21', '其他','Y', 'Y', 22, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

commit;