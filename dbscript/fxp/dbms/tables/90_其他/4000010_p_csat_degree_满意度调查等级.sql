--
-- ����ȵ���ȼ�
--
-- v1.0 2016.12.27
-- author��wing
--
-- ˵��
-- 1���Ժ�����ϵͳ����ȵ����5�� 1-5 1 �ܲ�����  2 ������ 3 һ�� 4 ���� 5 ������
--
-- 
-- �޸���ʷ��
--
-- drop table fxp.p_csat_degree;
create table  fxp.p_csat_degree (
-- +-----------------------------+--------------+-----------+
   fcsat_degree_id               varchar2(32)   not null,   -- ����ȵ���ȼ�ID
   fcsat_degree_name             varchar2(30)   not null,   -- ����ȵ���ȼ����� 
   fcsat_degree_desc             varchar2(256),             -- ��ע
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
   constraint pk_p_csat_degree primary key (fcsat_degree_id)
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
