--
-- ������
--
-- v1.0 2017.03.04
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_order;
create table  fxp.p_order (
-- +-----------------------------+--------------+-----------+
   forder_id                     varchar2(32)   not null,   -- ����ID
   factivation_code              varchar2(30)   not null,   -- ������
   --
   -- ��Ʒ��Ϣ
   --
   fgoods_id                     varchar2(32)   not null,   -- ��Ʒid
   fgoods_name                   varchar2(100)  not null,   -- ��Ʒ����
   fgoods_price                  number(10,2)   not null,   -- ��Ʒ����
   fgoods_unit                   varchar2(30)   not null,   -- ��λ
   --
   -- ���
   --
   fquantity                     number(6,0)    not null,   -- ����
   fquantity_activate            number(6,0)    not null,   -- �Ѽ��������
   fsum_total                    number(10,2)   not null,   -- ���
   --
   -- ������Ϣ
   --
   fsell_circle_id               varchar2(32)   not null,   -- ��������Ȧid   
-- +-----------------------------+--------------+-----------+
   --
   -- ������Ϣ
   --
   fbuy_time                     date          not null,    -- ����ʱ��
   fbuy_circle_id                varchar2(32),              -- ������Ȧid
   fbuy_team_id                  varchar2(32),              -- ��������id 
   fbuy_user_id                  varchar2(32)  not null,    -- �������Աid
   fbuy_user_name                varchar2(50)  not null,    -- �������Ա����
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
   constraint pk_p_order primary key (forder_id)
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

--
-- �޸����
--
