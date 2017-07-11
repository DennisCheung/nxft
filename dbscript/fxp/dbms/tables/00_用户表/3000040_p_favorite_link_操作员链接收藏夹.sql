--
-- 操作员链接收藏夹
--
-- v1.0 2017.03.16
-- author：wing
--
-- 说明
-- 链接标题
-- 1、订单标题： 订单（商品名称：fxp.p_order.fgoods_name  购买者：fxp.p_order.fbuy_user_name 购买时间：fxp.p_order.fbuy_time  ）
--               订单（商品名称：400元居家养老服务  购买者：张小明 购买时间：2017-04-11 15:32  ）
--
--
-- 修改历史：
--
-- drop table fxp.p_favorite_link;
create table  fxp.p_favorite_link (
-- +-----------------------------+--------------+-----------+
   ffavorite_id                  varchar2(32)   not null,   -- 收藏ID
   fuser_id                      varchar2(32)   not null,   -- 用户ID
   fnote_type_id                 varchar2(30)   not null,   -- 单据类型ID    表头代名词
   fnote_id                      varchar2(150)  not null,   -- 任务要处理的单据主键,复合主键用逗号分隔
   flink_topic                   varchar2(100)  not null,   -- 链接标题
   flink_url                     varchar2(300)  not null,   -- 链接url
   fcreate_time                  date           not null,   -- 创建时间
   ffavorite_desc                varchar2(256),             -- 备注
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
   constraint pk_p_favorite_link primary key (ffavorite_id),
   constraint uk_p_favorite_link unique (fuser_id,fnote_type_id,fnote_id)
   --
   -- 约束
   --
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
create index fxp.idx_p_favorite_link_user on fxp.p_favorite_link(fuser_id);

--
-- 修改语句
--
