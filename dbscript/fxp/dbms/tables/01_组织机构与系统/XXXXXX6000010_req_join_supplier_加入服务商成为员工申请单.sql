--
-- 散客加入服务商申请单
--
--
-- v1.0 2016.08.26
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.req_join_supplier;
Create Table  fxp.req_join_supplier (
-- +-----------------------------+--------------+-----------+
   freqnote_id                   varchar2(32)   not null,   -- 申请单id
   --
   -- 申请单信息
   --
   fsupplier_id                  varchar2(32)   not null,   -- 服务商id
   fuser_id                      varchar2(32)   not null,   -- 用户id
   fuser_name                    varchar2(30)   not null,   -- 用户name
   freq_desc                     varchar2(60),              -- 申请备注
   --
   -- 创建者信息
   --
   fcreate_time                  date           not null,   -- 创建时间
   fcreate_user_id               varchar2(32)   not null,   -- 创建工号id
   fcreate_nickname              varchar2(30)   not null,   -- 创建姓名
   --
   -- 环节信息
   --
   --
   -- 申请单状态  1、 已新建  2 已接受  3、 已拒绝
   --
   --
   flast_state                   varchar2(30)   not null,   -- 最后状态，完成时ID
   flast_time                    date           not null,   -- 最新完成时间
   flast_user_id                 varchar2(32)   not null,   -- 最新完成操作员id
   flast_nickname                varchar2(40)   not null,   -- 最新完成操作员name
   flast_desc                    varchar2(256),             -- 流程备注
   --
   -- 下一环节的信息，采用待办作为入口
   --
   fnext_node_id                 varchar2(30),              -- 下一环节 常量，和环节状态、备注同时更新
   fnext_node_content            varchar2(300),             -- 下一环节工作内容
   --
   -- 完成信息
   --
   fis_complete                   char(1)       not null,   -- 申请单是否已完成？  Y/N
   fcomplete_state                varchar2(30),             -- 完成状态  SUCCESS  成功  FAIL 失败（取消）
   fcomplete_time                 date,                     -- 完成时间
   fcomplete_user_id              varchar2(32),             -- 完成工号id
   fcomplete_nickname             varchar2(30),             -- 完成姓名
   fcomplete_desc                 varchar2(256),            -- 完成备注
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
   constraint pk_req_join_supplier primary key (freqnote_id)
);



--
-- 同义词
--
--
-- 授权
--

--
--索引
--
create index fxp.idx_req_join_supplier_complete on fxp.req_join_supplier(fis_complete);
create index fxp.idx_req_join_supplier_supplier on fxp.req_join_supplier(fsupplier_id);
create index fxp.idx_req_join_supplier_time     on fxp.req_join_supplier(flast_time);
--
-- 修改语句：
--
--
