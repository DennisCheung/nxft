--
-- 套餐禁忌疾病表
--
-- v1.0 2017.05.10
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table nxft.meal_disease;
create table  nxft.meal_disease (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- 主键id
   fdisease_id                   varchar2(32)   not null,   -- 疾病id
   fdisease_name                 varchar2(40)   not null,   -- 疾病名称
   --
   fmeal_id                      varchar2(32)   not null,   -- 套餐id
   fdisease_desc                 varchar2(256),             -- 备注
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
   constraint pk_meal_disease primary key (fpk_id),
   constraint uk_meal_disease unique (fmeal_id,fdisease_id)
);

--
-- 同义词
--


--
-- 授权
--


--
-- 索引
--


--
-- 修改历史：
--
