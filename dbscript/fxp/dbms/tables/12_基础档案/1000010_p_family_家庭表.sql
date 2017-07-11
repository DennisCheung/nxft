--
-- 家庭表
--
-- v1.0 2015.01.12
-- author：wing
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_family;
Create Table fxp.p_family (
-- +-----------------------------+--------------+-----------+
   ffamily_id                    varchar2(32)   not null,   -- 家庭id
   ffamily_code                  varchar2(32)   not null,   -- 家庭编号
   ffamily_member                varchar2(100),             -- 家庭成员
   -- fhouseholder_name          varchar2(40),              -- 户主姓名
   -- 
   -- 代理人
   --
   fagent_name                   varchar2(30)   not null,   -- 代理人姓名
   fagent_mobile                 varchar2(30),              -- 代理人手机
   fagent_user_id                varchar2(32),              -- 代理人user_id   
   --
   -- 所属工作圈
   --
   fcircle_id                    varchar2(32)   not null,   -- 工作圈id
   fteam_id                      varchar2(32)   not null,   -- 呼叫中心id
   -- 
   -- 联系方式
   --
   ffamily_Phone                 varchar2(30),              -- 家庭电话
   ffamily_last_Phone            varchar2(30),              -- 家庭最新呼入电话
   -- fpostbox                   varchar2(6),               -- 邮政编码
   fregion_id                    varchar2(32),              -- 行政区域ID（其中包含省、市、区、街道、社区的各级编码），（只有最底层地址的编码，不含上级编码）
   fregion_name                  varchar2(80),              -- 行政区域名称（包含完整的行政区域名称，如：广东省广州市番禺区)
   faddress                      varchar2(200),             -- 详细地址（街道之后的详细地址）
   fmap_addr                     varchar2(200),             -- 地图地址
   flatitude                     number(19,16),               -- 纬度值
   flongitude                    number(19,16),               -- 经度值
   --
   -- 家庭情况
   --
   fliving_condi_name            varchar2(40),             -- 居住情况，多选，用逗号分隔
   ffamily_desc                  varchar2(256),            -- 家庭备注
   --
   -- 创建者
   --   
   fcreate_date                  date,                      -- 创建日期（录入时输入的日期） 
   fcreate_user_id               varchar2(32),              -- 创建操作员id
   fcreate_user_name             varchar2(30),              -- 创建操作员姓名   
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
   constraint pk_p_family primary key (ffamily_id),
   constraint uk_p_family_code unique (ffamily_code)
-- constraint uk_p_family_fixPhone unique (ffamily_fixPhone)
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
-- create index idx_p_family1 on fxp.p_family(fregion_id);
create index idx_p_family_agent on fxp.p_family(fagent_mobile);
create index idx_p_family_phone on fxp.p_family(ffamily_Phone);


--
-- 修改语句：
--
