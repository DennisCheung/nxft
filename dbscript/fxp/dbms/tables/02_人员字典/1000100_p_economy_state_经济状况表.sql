--
-- 经济状况表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_economy_state;
create table  fxp.p_economy_state (
-- +-----------------------------+--------------+-----------+
   feconomy_state_id             varchar2(32)   not null,   -- 经济状况ID
   feconomy_state_code           varchar2(8)    not null,   -- 经济状况代码
   feconomy_state_gbcode         varchar2(32),              -- 国标代码
   feconomy_state_name           varchar2(40)   not null,   -- 经济状况名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入备注 
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   feconomy_state_desc           varchar2(256),             -- 备注
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
   constraint pk_p_economy_state primary key (feconomy_state_id),
   constraint uk_p_economy_state_code unique (feconomy_state_code)
);

--
-- 同义词
--
insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '在职', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '离休', 'N', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '退休', 'N', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '待业', 'N', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '低保', 'N', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', '困难', 'N', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '其它', 'N', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;
