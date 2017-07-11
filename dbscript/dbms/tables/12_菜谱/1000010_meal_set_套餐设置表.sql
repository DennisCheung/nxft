--
-- 套餐设置表
--
-- v1.0 2017.04.29
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table nxft.meal_set;
Create Table  nxft.meal_set (
-- +-----------------------------+--------------+-----------+
   fmeal_id                      varchar2(32)   not null,   -- 套餐id
   fmeal_code                    varchar2(30)   not null,   -- 套餐CODE
   fmeal_name                    varchar2(40)   not null,   -- 套餐名称
   fmeal_content                 varchar2(60)   not null,   -- 套餐内容
   ftaboo_disease                varchar2(100),             -- 禁忌疾病，名称逗号分隔
   fpeppery_level                number(1),                 -- 辣度
   fmeal_price                   number(4,2)    not null,   -- 单价
   fphoto_id                     varchar2(32),              -- 最新图片id
   fkitchen_circle_id            varchar2(32)   not null,   -- 厨房圈id
   fkitchen_team_id              varchar2(32)   not null,   -- 厨房teamid
   fisavailable                  char(1)        not null,   -- 是否可用？
   fmeal_desc                    varchar2(256),             -- 备注   
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
   constraint pk_meal_set primary key (fmeal_id),
   constraint uk_meal_set unique (fkitchen_team_id,fmeal_code)
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
