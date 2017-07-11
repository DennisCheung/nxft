--
-- 疾病字典表
--
-- v1.0 2015.06.11
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table fxp.p_disease;
create table  fxp.p_disease (
-- +-----------------------------+--------------+-----------+
   fdisease_id                   varchar2(32)   not null,   -- 疾病ID
   fdisease_code                 varchar2(20)   not null,   -- 疾病代码
   fdisease_name                 varchar2(100)  not null,   -- 疾病名称
   fdisease_class_id             varchar2(32)   not null,   -- 疾病大类ID
   fdisease_class_name           varchar2(60)   not null,   -- 疾病大类NAME
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入
   fisdisease                    char(1)        not null,   -- 是否是其疾病 Y/N，可供输入疾病时选择
   fis_hg_use                    char(1)        not null,   -- 健康指导是否可用
   fis_sf_use                    char(1)        not null,   -- 回访是否可用
   fis_hmo_use                   char(1)        not null,   -- 健康监测是否可用   
   fdisease_desc                 varchar2(256),             -- 备注
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
   constraint pk_p_disease primary key (fdisease_id),
   constraint uk_p_disease_code unique (fdisease_code)
);

--
-- 同义词
--

