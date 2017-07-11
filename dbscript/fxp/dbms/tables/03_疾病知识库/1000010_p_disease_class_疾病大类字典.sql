--
-- 疾病大类字典表
--
-- v1.0 2015.06.11
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_disease_class;
create table  fxp.p_disease_class (
-- +-----------------------------+--------------+-----------+
   fdisease_class_id             varchar2(32)   not null,   -- 疾病大类ID
   fdisease_class_code           varchar2(8)    not null,   -- 疾病大类代码
   fdisease_class_name           varchar2(60)   not null,   -- 疾病大类名称
   fdisease_class_desc           varchar2(256),             -- 疾病备注
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
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
   constraint pk_p_disease_class primary key (fdisease_class_id),
   constraint uk_p_disease_class_code unique (fdisease_class_code)
);

--
-- 同义词
--
