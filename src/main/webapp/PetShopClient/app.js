Ext.application({
    name: 'EmployeeCatalog',

    views: [
      'AddEmployeeFormView',
      'EmployeeCatalogView',
      'EmployeeGridView'
    ],

    controllers : [
        'EmployeeCatalogController'
    ],

    stores : [
        'EmployeeCatalogStore'
    ],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype  : 'employeeCatalogView'
            }
        });
    }
});
