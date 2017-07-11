--
-- 身份识别表
--
-- v1.0 2016.10.08
-- author：wing
--
-- 修改历史：
-- 
--
--   
-- drop table fxp.p_ids;
create table  fxp.p_ids (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户id
   --
   -- 个人基本信息
   -- 
   fidtype_id                    varchar2(32),              -- 证件类别id ->p_id_typ
   fidtype_name                  varchar2(30),              -- 证件类别中文     微信默认二代身份证
   fid_no                        varchar2(30),              -- 证件编号（身份证）
   fbirth_date                   date,                      -- 出生日期, 年龄通过出生日期计算出来。
   --
   -- 居住情况
   --
   fregion_id                    varchar2(32),              -- 行政区域ID（其中包含省、市、区、街道、社区的各级编码），（只有最底层地址的编码，不含上级编码）
   fregion_name                  varchar2(80),              -- 行政区域名称（包含完整的行政区域名称，如：广东省广州市番禺区)
   faddress                      varchar2(200),             -- 详细地址（街道之后的详细地址）
   --
   -- 联系电话
   --
   fuser_mobile                  varchar2(30),              -- 注册手机
   fuser_desc                    varchar2(256),             -- 客户备注
   -- 
   -- 代理人
   --
   fagent_name                   varchar2(30),              -- 代理人姓名
   fagent_mobile                 varchar2(30),              -- 代理人手机     
   --
   -- 创建
   --
   fcreate_date                   date default sysdate not null, -- 注册日期（录入时输入的日期） 
   fcreate_user_id                varchar2(32),              -- 注册操作员id
   fcreate_user_name              varchar2(30),              -- 注册操作员姓名
-- +-----------------------------+--------------+-----------+
   --
   -- 日志
   --
   fversion                      number(6)                  -- 版本号
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- 创建者
   flogcdate                     date default sysdate not null,   -- 创建时间
   flogluby                      varchar2(32)   not null,   -- 最后修改者
   flogludate                    date default sysdate not null,   -- 最后修改时间
   floglaby                      varchar2(32)   not null,   -- 最后访问者
   flogladate                    date default sysdate not null,   -- 最后访问时间
   --
   -- 主键、唯一键
   --
   constraint pk_p_ids primary key (fuser_id),
   constraint uk_p_ids_idno unique (fid_no),
   constraint uk_p_ids_mobile unique (fuser_mobile)
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
create index idx_p_ids_agent_mobile on fxp.p_ids(fagent_mobile);
