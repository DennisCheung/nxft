--
-- 性别字典表
--
-- v1.0 2014.12.08
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.p_sex;
create Table fxp.p_sex (
-- +-----------------------------+--------------+-----------+		
   fsex_id                       varchar2(32)   not null,   -- ID
   fsex_code                     varchar2(8)    not null,   -- 代码
   fsex_gbcode                   varchar2(32),              -- 国标代码
   fsex_name                     varchar2(40)   not null,   -- 名称
   --
   fisavailable                  char(1)        not null,   -- 是否可用？
   fordernum                     number(6,2)    not null,   -- 排序号
   fsex_desc                     varchar2(256),             -- 备注      
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
   constraint pk_p_sex primary key (fsex_id),
   constraint uk_p_sex_code unique (fsex_code)
   );

--
-- 同义词
--

insert into p_sex (FSEX_ID, FSEX_CODE, FSEX_GBCODE, FSEX_NAME, FISAVAILABLE, FORDERNUM, FSEX_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1', '1', '1', '男', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_sex (FSEX_ID, FSEX_CODE, FSEX_GBCODE, FSEX_NAME, FISAVAILABLE, FORDERNUM, FSEX_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('2', '2', '2', '女', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit ;