import { NgModule } from '@angular/core';
import { UsuariosIndexComponent } from './pages/index/index.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuariosEditComponent } from './pages/edit/edit.component';
import { UsuariosRoutingModule } from './usuarios.routing';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        UsuariosRoutingModule,
    ],
    exports: [
    ],
    declarations: [
        UsuariosIndexComponent,
        UsuariosEditComponent
    ],
    providers: [],
    entryComponents: [
        UsuariosEditComponent,
    ]
})
export class UsuariosModule { }
