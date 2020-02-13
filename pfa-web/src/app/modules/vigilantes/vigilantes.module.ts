
import { NgModule } from '@angular/core';
import { VigilantesIndexComponent } from './pages/index/index.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { VigilantesEditComponent } from './pages/edit/edit.component';
import { VigilantesRoutingModule } from './vigilantes.routing';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        VigilantesRoutingModule,
    ],
    exports: [
    ],
    declarations: [
        VigilantesIndexComponent,
        VigilantesEditComponent
    ],
    providers: [],
    entryComponents: [
        VigilantesEditComponent,
    ]
})
export class VigilantesModule { }