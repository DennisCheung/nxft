--
-- 宗教信仰字典表
--
-- v1.0 2017.03.15
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_religion;
create table  fxp.p_religion (
-- +-----------------------------+--------------+-----------+
   freligion_id                  varchar2(32)   not null,   -- 宗教信仰ID
   freligion_code                varchar2(8)    not null,   -- 宗教信仰代码
   freligion_name                varchar2(40)   not null,   -- 宗教信仰名称
   fisavailable                  char(1)        not null,   -- 是否可用？
   freligion_desc                varchar2(256),             -- 备注
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
   constraint pk_p_religion primary key (freligion_id),
   constraint uk_p_religion_code unique (freligion_code)
);

--
-- 同义词
--
