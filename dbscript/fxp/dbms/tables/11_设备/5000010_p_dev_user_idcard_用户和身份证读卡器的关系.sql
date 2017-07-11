--
-- 身份证读卡器与用户的绑定关系
--
-- v1.0 2016.12.10
-- author：alex
--
-- 修改历史：
--
--
--
-- Drop Table fxp.p_dev_user_idcard;
create table  fxp.p_dev_user_idcard (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- 用户ID
   fuser_name                    varchar2(50)   not null,   -- 用户姓名
   --
   -- 设备详情
   --
   fdevice_sn                    varchar2(32)   not null,   -- 设备序列号
   --
   -- 更新信息
   --
   fbind_date                    date           not null,   -- 最后一次绑定的时间
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
   constraint pk_p_dev_user_idcard primary key (fuser_id)
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
-- 修改历史：
--
