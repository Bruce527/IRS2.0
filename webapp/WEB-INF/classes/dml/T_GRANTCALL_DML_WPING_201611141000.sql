/**
作者:王萍
功能:调用赋权和建立同义词，有表更动或者建立时调用
日期:2016-11-14
**/
CALL pkg_gyas_grant_infra.p_bulk_grant_to_app_s1('ICP_PRO','ICP_PRO_APP');
CALL pkg_gyas_grant_infra.p_bulk_create_syn_for_app_s2('ICP_PRO','ICP_PRO_APP');