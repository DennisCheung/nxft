--
-- 国籍表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
-- drop table fxp.p_citizenship;
create table  fxp.p_citizenship (
-- +-----------------------------+--------------+-----------+
   fcitizenship_id               varchar2(32)   not null,   -- 国籍ID
   fcitizenship_code             varchar2(8)    not null,   -- 国籍代码
   fcitizenship_gbcode           varchar2(32),              -- 国标代码
   fcitizenship_name             varchar2(40)   not null,   -- 国籍名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入备注
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fcitizenship_desc             varchar2(256),             -- 备注
-- +-----------------------------+--------------+-----------+
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
   constraint pk_p_citizenship primary key (fcitizenship_id),
   constraint uk_p_citizenship_code unique (fcitizenship_code)
   );

--
-- 同义词
--

insert into p_citizenship (FCITIZENSHIP_ID, FCITIZENSHIP_CODE, FCITIZENSHIP_GBCODE, FCITIZENSHIP_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FCITIZENSHIP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', '中国', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_citizenship (FCITIZENSHIP_ID, FCITIZENSHIP_CODE, FCITIZENSHIP_GBCODE, FCITIZENSHIP_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FCITIZENSHIP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '外国', 'Y', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;