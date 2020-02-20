import { NgModule } from '@angular/core';
import { ContratacionesIndexComponent } from './pages/index/index.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ContratacionesEditComponent } from './pages/edit/edit.component';
import { ContratacionesRoutingModule } from './contrataciones.routing';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        ContratacionesRoutingModule,
    ],
    exports: [
    ],
    declarations: [
        ContratacionesIndexComponent,
        ContratacionesEditComponent
    ],
    providers: [],
    entryComponents: [
        ContratacionesEditComponent,
    ]
})
export class ContratacionesModule { }
