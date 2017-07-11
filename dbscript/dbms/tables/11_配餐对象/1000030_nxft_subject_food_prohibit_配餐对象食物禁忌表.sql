--
-- 配餐对象食物禁忌表
--
-- v1.0 2017.06.01
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table nxft.nxft_subject_food_prohibit;
create table  nxft.nxft_subject_food_prohibit (
-- +-----------------------------+--------------+-----------+
   fpk_id                        varchar2(32)   not null,   -- 主键id
   ffood_prohibit_id             varchar2(32)   not null,   -- 食物禁忌id
   ffood_prohibit_name           varchar2(40)   not null,   -- 食物禁忌名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入备注 
   --
   fsubject_id                   varchar2(32)   not null,   -- 对象id
   ffood_prohibit_desc           varchar2(256),             -- 备注
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
   constraint pk_nxft_subject_food_prohibit primary key (fpk_id),
   constraint uk_nxft_subject_food_prohibit unique (fsubject_id,ffood_prohibit_id)
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
