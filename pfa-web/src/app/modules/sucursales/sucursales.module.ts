import { NgModule } from '@angular/core';
import { SucursalesIndexComponent } from './pages/index/index.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SucursalesRoutingModule } from './sucursales.routing';
import { SucursalesEditComponent } from './pages/edit/edit.component';

@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        SucursalesRoutingModule,
    ],
    exports: [],
    declarations: [
        SucursalesIndexComponent,
        SucursalesEditComponent,
    ],
    providers: [],
})
export class SucursalesModule { }
