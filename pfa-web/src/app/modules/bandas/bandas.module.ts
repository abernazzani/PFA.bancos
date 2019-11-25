import { NgModule } from '@angular/core';
import { BandasIndexComponent } from './pages/index/index.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BandasEditComponent } from './pages/edit/edit.component';
import { BandasRoutingModule } from './bandas.routing';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
    imports: [
        NgbModule,
        CommonModule,
        RouterModule,
        FormsModule,
        BandasRoutingModule,
    ],
    exports: [
    ],
    declarations: [
        BandasIndexComponent,
        BandasEditComponent
    ],
    providers: [],
    entryComponents: [
        BandasEditComponent,
    ]
})
export class BandasModule { }
