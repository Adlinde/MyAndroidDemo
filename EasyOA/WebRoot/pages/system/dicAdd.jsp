<%@ page language="java"  pageEncoding="UTF-8"%>
<table width="80%" border="0" class="table_thintd" align="center">
   <tr>
    <td align="right">分类：</td>
    <td>
        <input class="easyui-combobox" id="language" name="language"
			data-options="url:'combobox_data1.json',valueField:'id',textField:'text'">
    </td>
  </tr>
  <tr>
    <td align="right">字典项：</td>
    <td><label for="textfield"></label>
    <input type="text" name="textfield" id="textfield" /></td>
  </tr>
  <tr>
    <td align="right">字典值：</td>
    <td><input type="text" name="textfield2" id="textfield2" /></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
        <a href="#" class="easyui-linkbutton" style="vertical-align: middle"> 保 存 </a>
    </td>
  </tr>
</table>
