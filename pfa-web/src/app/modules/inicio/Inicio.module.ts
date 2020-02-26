import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { InicioRoutingModule } from './Inicio.routing';
import { InicioIndexComponent } from './pages/index/index.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        InicioRoutingModule,
    ],
    exports: [
    ],
    declarations: [
        InicioIndexComponent,
        
    ],
    providers: [],
    entryComponents: [
   ]
})
export class InicioModule { }
