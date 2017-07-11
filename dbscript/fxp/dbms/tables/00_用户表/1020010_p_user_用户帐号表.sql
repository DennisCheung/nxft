--
-- 用户帐号表
--
-- v1.0 2015.11.09
-- author：wing
-- 说明：
-- 1、用户包括：客户、职工、其他使用系统使用人士。
-- 2、职工用户
--  2.1、添加职工：
--    ① 自动在用户表P_USER中增加一条记录。
--       fuser_id = femp_id
--       系统试用阶段fpassword=11111  正式使用阶段，首次使用执行“忘记密码”功能，通过职工登记的手机短信校验码或邮件链接设置密码。
--       fnickname = femp_name
--    ② 如电话不为空，插p_user_mobile
--    ③ 如邮箱不为空，插p_user_email
--  2.2、 修改职工：
--    ① 实现p_employee 和p_user,p_user_mobile,p_user_emai 信息同步
--  2.3、 职工登录(APP,WEB)
--    ①  输入user_id和密码
--    ②  输入登记的手机号和密码
--    ③  输入登记的邮箱号和密码
--   2.4  职工微信企业号绑定
--    ①  通讯录中登记手机号或邮箱或微信号，点击“邀请关注”，
--    ②  职工确认关注，建立OPEN_ID 和 通讯录职工的绑定关系
--   2.5  职工微信企业号登录
--    ①  进入微信，职工工号= 通讯录账号， 找到user_id
--
--
-- 3、用户注册：
--   3.1、 通过各种端（QQ方式、微信、APP、WEB）“用户注册”功能，注册成为用户
--         fuser_id  通过序列号自动生成。
--         fpassword  输入和再次确定密码
--         输入昵称、性别
--         输入注册验证的手机，需通过短信验证。
--         输入邮箱（可为空）
--   3.2、新用户从微信入口：自动实现微信OPEN_ID 和user_id绑定，并将绑定关系存储到 p_user_wachart
--   3.3、老用户从微信入口：通过输入user_id（注册手机、邮箱） 和 密码
--
--
-- 修改历史：
--
--
-- drop table fxp.p_user;
create table  fxp.p_user (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户id
   fpassword                     varchar2(50),              -- 用户密码，密码需加密存储，如果为空不允许直接输入用户id登录
   fnickname                     varchar2(50)   not null,   -- 显示名(昵称）
   fsex_id                       varchar2(32),              -- 性别id
   fsex_name                     varchar2(10),              -- 性别名称
   fphoto_id                     varchar2(32),              -- 最新头像id
   fsignature_id                 varchar2(32),              -- 最新签名id
   fmobile                       varchar2(20),              -- 手机号
   fuser_desc                    varchar2(256),             -- 备注
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
   constraint pk_p_user primary key (fuser_id)
   --
   -- 约束
   --
 --  constraint ck_p_user_fis_activated check (fis_activated in ('Y','N'))
);

alter table FXP.p_user
  add constraint UK_p_user_fmobile unique (fmobile);

--
-- 授权
--
  grant all on fxp.p_user to sf,hbcs;
--
-- 索引
--

--
-- 修改语句
--

--
-- 初始数据
--


