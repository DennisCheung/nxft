--
-- 服务项目表
--
-- v1.0 2017.03.08
-- author：wing
--
-- 说明
--
--
-- 
-- 修改历史：
--
-- drop table fxp.p_item;
create table  fxp.p_item (
-- +-----------------------------+--------------+-----------+
   fitem_id                      varchar2(32)   not null,   -- 服务项目ID
   fitem_name                    varchar2(50)   not null,   -- 服务项目名称
   fproduct_id                   varchar2(32)   not null,   -- 服务目录ID
   fitem_info                    varchar2(200),             -- 项目信息
   fisavailable                  char(1)        not null,   -- 是否可用？
   fitem_desc                    varchar2(256),             -- 备注
   --   
   -- 价格
   --   
   fitem_price                   number(8,2),               -- 价格
   fupdate_price                 char(1)        not null,   -- 是否允许修改价格
   fitem_unit                    varchar2(20)   not null,   -- 单位
   fcharge_mode                  varchar2(10)   not null,   -- 计费模式  常量（ 包月  按次 ）
   --
   -- 所属圈
   --
   fcircle_id                    varchar2(32)   not null,   -- 所属工作圈id（上架者）    
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
   constraint pk_p_item primary key (fitem_id),
   constraint check_p_item_charge_mode  check (fcharge_mode IN ('包月','按次'))
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


--
-- 修改语句
--
