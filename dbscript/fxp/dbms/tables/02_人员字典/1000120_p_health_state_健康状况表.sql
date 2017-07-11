--
-- 健康状况表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_health_state;
create table  fxp.p_health_state (
-- +-----------------------------+--------------+-----------+
   fhealth_state_id              varchar2(32)   not null,   -- 健康状况ID
   fhealth_state_code            varchar2(8)    not null,   -- 健康状况代码
   fhealth_state_gbcode          varchar2(32),              -- 国标代码
   fhealth_state_name            varchar2(40)   not null,   -- 健康状况名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fhealth_state_desc            varchar2(256),             -- 备注
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
   constraint pk_p_health_state primary key (fhealth_state_id),
   constraint uk_p_health_state_code unique (fhealth_state_code)
);

--
-- 同义词
--

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '健康', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '一般', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '差', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '残疾', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '高龄', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;