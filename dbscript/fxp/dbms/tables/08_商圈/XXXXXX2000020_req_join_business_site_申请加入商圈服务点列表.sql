--
-- 申请加入商圈服务点列表
--
--
-- v1.0 2016.08.12
-- author：wing
--
-- 修改历史：
--
--
-- Drop Table fxp.req_join_business_site;
Create Table  fxp.req_join_business_site (
-- +-----------------------------+--------------+-----------+
   freqnote_id                   varchar2(32)   not null,   -- 申请单id
   --
   -- 申请单信息
   --
   fbusiness_circle_id           varchar2(32)   not null,   -- 商圈id
   foperator_id                  varchar2(32)   not null,   -- 运营商id
   fsupplier_id                  varchar2(32)   not null,   -- 服务商id
   fsite_id                      varchar2(32)   not null,   -- 服务点id
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
   constraint pk_req_join_business_site primary key (freqnote_id,fsite_id)
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

--
-- 修改语句：
--
--
