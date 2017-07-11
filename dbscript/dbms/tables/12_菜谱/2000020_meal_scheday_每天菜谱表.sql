--
-- 每天菜谱表
--
-- v1.0 2017.04.29
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table nxft.meal_scheday;
Create Table  nxft.meal_scheday (
-- +-----------------------------+--------------+-----------+
   fschedule_id                  varchar2(32)   not null,   -- 安排id
   --
   -- 所属机构
   --
   fkitchen_circle_id            varchar2(32)   not null,   -- 厨房圈id
   fkitchen_team_id              varchar2(32)   not null,   -- 厨房teamid
   --
   -- 排班
   --
   fschenote_id                  varchar2(32)   not null,   -- 排班单id
   fmeal_date                    date           not null,   -- 就餐日期
   fweek                         number(1)      not null,   -- 周几
   fmeal_type_id                 varchar2(32)   not null,   -- 餐别ID
   fmeal_type_name               varchar2(40)   not null,   -- 餐别名称
   fmeal_id                      varchar2(32)   not null,   -- 套餐id
   fmeal_code                    varchar2(30)   not null,   -- 套餐CODE
   fmeal_name                    varchar2(40)   not null,   -- 套餐名称
   fmeal_content                 varchar2(60)   not null,   -- 套餐内容
   fmeal_price                   number(4,2)    not null,   -- 单价
   fschedule_desc                varchar2(256),             -- 备注
   --
   -- 发布
   --
   fis_published                 char(1)        not null,   -- 是否已发布？ Y/N
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
   constraint pk_meal_scheday primary key (fschedule_id),
   constraint uk_meal_scheday unique (fmeal_date,fmeal_type_id,fmeal_id)
   --
   -- 约束
   --
);

--
-- 索引
--

--
-- 修改语句
--
