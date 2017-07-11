--
-- 食物禁忌表
--
-- v1.0 2017.06.01
-- author：wing
--
-- 修改历史：
--
--
--
-- drop table nxft.d_food_prohibit;
create table  nxft.d_food_prohibit (
-- +-----------------------------+--------------+-----------+
   ffood_prohibit_id             varchar2(32)   not null,   -- 食物禁忌ID
   ffood_prohibit_code           varchar2(8)    not null,   -- 食物禁忌代码
   ffood_prohibit_name           varchar2(40)   not null,   -- 食物禁忌名称
   fisother                      char(1)        not null,   -- 是否是其他项 Y/N  其他项需手工输入备注 
   ffood_prohibit_desc           varchar2(256),             -- 备注
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
   constraint pk_d_food_prohibit primary key (ffood_prohibit_id)
);

--
-- 同义词
--
