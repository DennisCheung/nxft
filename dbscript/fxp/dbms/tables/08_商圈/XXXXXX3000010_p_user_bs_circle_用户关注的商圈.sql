--
-- �û���ע����Ȧ��
--
-- v1.0 2016.08.27
-- author��wing
--
-- ˵��
--
--
--
-- �޸���ʷ��
--
-- drop table fxp.p_user_bs_circle;
create table  fxp.p_user_bs_circle (
-- +-----------------------------+--------------+-----------+
   fuser_id                      varchar2(32)   not null,   -- �û�ID
   fbusiness_circle_id           varchar2(32)   not null,   -- ��Ȧid
   fcreate_date                  date default sysdate not null, -- ����ʱ�䣨¼��ʱ��������ڣ� 
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
   constraint pk_p_user_bs_circle primary key (fuser_id,fbusiness_circle_id)
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
