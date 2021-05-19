Ext.define('EmployeeCatalog.controller.EmployeeCatalogController', {
    extend: 'Ext.app.Controller',

    refs: [
        {selector: 'employeeGridView',
            ref: 'employeeGridView'},
        {selector: 'employeeGridView button[action="create"]',
            ref: 'employeeGridAdd'},
        {selector: 'employeeGridView button[action="delete"]',
            ref: 'employeeGridDelete'},
        {selector: 'addEmployeeFormView',
            ref: 'addEmployeeFormView'},
        {selector: 'employeeCatalogView',
            ref: 'employeeCatalogView'},
        {selector: 'addEmployeeFormView textfield[name=name] ',
            ref: 'addEmployeeFormName'},
        {selector: 'addEmployeeFormView textfield[name=lastName]',
            ref: 'addEmployeeFormLastName'},
        {selector: 'addEmployeeFormView textfield[name=age]',
            ref: 'addEmployeeFormAge'},
        {selector: 'addEmployeeFormView textfield[name=positionName]',
            ref: 'addEmployeeFormPositionName'},
        {selector: 'addEmployeeFormView button[action=save]',
            ref: 'addEmployeeFormSave'}
    ],

    init: function () {
        this.control({
            'employeeGridView  button[action=create]': {
                click: this.onAddEmployee
            },
            'employeeGridView  button[action=delete]': {
                click: this.onDelEmployee
            },
            'employeeGridView': {
                cellclick: this.onLineGrid
            },
            'addEmployeeFormView  button[action=save]': {
                click: this.onSaveEmployee
            },
            'addEmployeeFormView  textfield[name=name]': {
                change: this.onValidation
            },
            'addEmployeeFormView  textfield[name=lastName]': {
                change: this.onValidation
            },
            'addEmployeeFormView textfield[name=age]': {
                change: this.onValidation
            },
            'addEmployeeFormView textfield[name=positionName]': {
                change: this.onValidation
            }
        });
    },

    //Функция сохранения пользователя.
    onSaveEmployee: function (button) {
        var me = this;
        var employeeModel = Ext.create('EmployeeCatalog.model.EmployeeCatalogModel');
        employeeModel.set(this.getAddEmployeeFormView().down('form').getValues());
        employeeModel.save({
            success: function (operation, response) {
                var objAjax = operation.data;
                Ext.getStore('EmployeeCatalogStore').add(objAjax);
                me.getAddEmployeeFormView().close();
            },
            failure: function (dummy, result) {
                Ext.MessageBox.show({
                    title: 'Ошибка добавления',
                    msg: 'Ошибка создания нового пользователя!',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.ERROR
                });
            }

        });
    },

    onAddEmployee: function () {
        Ext.widget('addEmployeeFormView');
    },

    //Функция удаления сотрудника
    onDelEmployee: function () {
        var sm = this.getEmployeeGridView().getSelectionModel();
        var rs = sm.getSelection();
        this.getEmployeeGridView().store.remove(rs[0]);
        this.getEmployeeGridView().store.commitChanges();
        this.getEmployeeGridDelete().disable();
    },

    onLineGrid: function () {
        this.getEmployeeGridDelete().enable();
    },

    onValidation: function () {
        if (this.getAddEmployeeFormName().validate() && this.getAddEmployeeFormLastName().validate() && this.getAddEmployeeFormAge().validate() && this.getAddEmployeeFormPositionName().validate()) {
            this.getAddEmployeeFormSave().enable();
        } else {
            this.getAddEmployeeFormSave().disable();
        }
    }

});
