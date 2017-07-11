--
-- 商品表
--
--
-- v1.0 2017.03.14
-- author：wing
--
-- 说明：
-- 
--
-- 修改历史：
--
--
-- Drop Table fxp.p_goods ;
Create Table  fxp.p_goods (
-- +-----------------------------+--------------+-----------+
   fgoods_id                     varchar2(32)   not null,   -- 商品id
   fgoods_code                   varchar2(30)   not null,   -- 商品code
   fgoods_name                   varchar2(100)  not null,   -- 商品名称
   fbusiness_id                  varchar2(32)   not null,   -- 业务id
   fgoods_info                   varchar2(2000) not null,   -- 商品详细信息
   fgoods_price                  number(10,2)   not null,   -- 商品单价
   fgoods_unit                   varchar2(30)   not null,   -- 单位
   fgoods_desc                   varchar2(256),             -- 商品的备注
   --
   -- 所属圈
   --
   fcircle_id                    varchar2(32)   not null,   -- 所属工作圈id（上架者）  
   --
   -- 创建
   --
   fcreate_date                  date           not null,   -- 创建时间  
   fcreate_user_id               varchar2(32)   not null,   -- 创建操作员id
   fcreate_nickname              varchar2(30)   not null,   -- 创建操作员姓名      
   --
   -- 取消
   --
   fis_cancel                    char(1) default 'N'  not null, -- 是否被注销
   fcancel_reason                varchar2(100),             -- 注销原因
   fcancel_date                  date,                      -- 注销时间
   fcancel_user_id               varchar2(32),              -- 注销操作员id
   fcancel_nickname              varchar2(40),              -- 注销操作员姓名   
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
   constraint pk_p_goods primary key (fgoods_id),
   constraint uk_p_goods unique (fcircle_id,fgoods_code)
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
