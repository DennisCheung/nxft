--
-- 政府扶助类型字典表
--
-- v1.0 2017.06.01
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_gov_help;
create table  fxp.p_gov_help (
-- +-----------------------------+--------------+-----------+
   fgov_help_id                  varchar2(32)   not null,   -- 扶助类型ID
   fgov_help_code                varchar2(8)    not null,   -- 扶助类型代码
   fgov_help_name                varchar2(40)   not null,   -- 扶助类型名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N 
   fgov_help_desc                varchar2(256),             -- 备注
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                   -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date           not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date           not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date           not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_gov_help primary key (fgov_help_id),
   constraint uk_p_gov_help_code unique (fgov_help_code)
);

--
-- 同义词
--
