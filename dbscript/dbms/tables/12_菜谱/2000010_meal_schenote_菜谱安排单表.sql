--
-- 菜谱安排单表
--
-- v1.0 2017.04.29
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table nxft.meal_schenote;
Create Table  nxft.meal_schenote (
-- +-----------------------------+--------------+-----------+
   fschenote_id                  varchar2(32)   not null,   -- 排班单id
   fschenote_desc                varchar2(256),             -- 排班单备注   
   --
   -- 所属机构
   --
   fkitchen_circle_id            varchar2(32)   not null,   -- 厨房圈id
   fkitchen_team_id              varchar2(32)   not null,   -- 厨房teamid
   --
   -- 排班
   --
   fbegin_date                   date           not null,   -- 排班起始日期=上周期终止日期 + 1
   fend_date                     date           not null,   -- 排班终止日期
   fperiod_model                 varchar2(20)   not null,   -- 排班周期模式 WEEK 周 MONTH 月
   --
   -- 创建信息
   --
   fcreate_time                  date           not null,   -- 创建时间
   fcreate_user_id               varchar2(32)   not null,   -- 创建工号id
   fcreate_nickname              varchar2(30)   not null,   -- 创建姓名
   --
   -- 发布信息
   --   
   fis_published                 char(1)        not null,   -- 是否已发布？ Y/N
   fpublish_time                 date,                      -- 发布时间
   fpublish_user_id              varchar2(32),              -- 发布工号id
   fpublish_nickname             varchar2(30),              -- 发布姓名
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
   constraint pk_meal_schenote primary key (fschenote_id)
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
