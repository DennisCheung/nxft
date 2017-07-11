--
-- 沟通语言字典表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_language;
create Table  fxp.p_language (
-- +-----------------------------+--------------+-----------+		
   flanguage_id                  varchar2(32)   not null,   -- ID
   flanguage_code                varchar2(8)    not null,   -- 代码
   flanguage_gbcode              varchar2(32),              -- 国标代码
   flanguage_name                varchar2(40)   not null,   -- 名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入备注
   --
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   flanguage_desc                varchar2(256),             -- 备注      
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
   constraint pk_p_language primary key (flanguage_id),
   constraint uk_p_language_code unique (flanguage_code)
   );

--
-- 同义词
--

insert into p_language (FLANGUAGE_ID, FLANGUAGE_CODE, FLANGUAGE_GBCODE, FLANGUAGE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FLANGUAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '普通话', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into p_language (FLANGUAGE_ID, FLANGUAGE_CODE, FLANGUAGE_GBCODE, FLANGUAGE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FLANGUAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '本地话', 'N', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_language (FLANGUAGE_ID, FLANGUAGE_CODE, FLANGUAGE_GBCODE, FLANGUAGE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FLANGUAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '其他', 'Y', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;
