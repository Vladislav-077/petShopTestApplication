Ext.define('EmployeeCatalog.view.EmployeeCatalogView', {
    extend: 'Ext.panel.Panel',
    width: 500,
    height: 360,
    padding: 10,
    alias: 'widget.employeeCatalogView',
    layout: 'border',
    items: [
        {
            xtype: 'employeeGridView',
            region: 'center'
        },
        {
            xtype: 'panel',
            html: '<div style="font: normal 18px cursive"><center><font size = "10">Список сотрудников компании</font></center></div>',
            region: 'north',
            height: 80
        }
    ],
    renderTo: Ext.getBody()
});
