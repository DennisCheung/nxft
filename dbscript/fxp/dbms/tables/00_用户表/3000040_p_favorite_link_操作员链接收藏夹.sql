--
-- ����Ա�����ղؼ�
--
-- v1.0 2017.03.16
-- author��wing
--
-- ˵��
-- ���ӱ���
-- 1���������⣺ ��������Ʒ���ƣ�fxp.p_order.fgoods_name  �����ߣ�fxp.p_order.fbuy_user_name ����ʱ�䣺fxp.p_order.fbuy_time  ��
--               ��������Ʒ���ƣ�400Ԫ�Ӽ����Ϸ���  �����ߣ���С�� ����ʱ�䣺2017-04-11 15:32  ��
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_favorite_link;
create table  fxp.p_favorite_link (
-- +-----------------------------+--------------+-----------+
   ffavorite_id                  varchar2(32)   not null,   -- �ղ�ID
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   fnote_type_id                 varchar2(30)   not null,   -- ��������ID    ��ͷ������
   fnote_id                      varchar2(150)  not null,   -- ����Ҫ����ĵ�������,���������ö��ŷָ�
   flink_topic                   varchar2(100)  not null,   -- ���ӱ���
   flink_url                     varchar2(300)  not null,   -- ����url
   fcreate_time                  date           not null,   -- ����ʱ��
   ffavorite_desc                varchar2(256),             -- ��ע
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_favorite_link primary key (ffavorite_id),
   constraint uk_p_favorite_link unique (fuser_id,fnote_type_id,fnote_id)
   --
   -- Լ��
   --
);

--
-- ͬ���
--

--
-- ��Ȩ
--

--
-- ����
--
create index fxp.idx_p_favorite_link_user on fxp.p_favorite_link(fuser_id);

--
-- �޸����
--
