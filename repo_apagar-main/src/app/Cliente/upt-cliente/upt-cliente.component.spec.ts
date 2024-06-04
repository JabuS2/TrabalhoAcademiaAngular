import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UptClienteComponent } from './upt-cliente.component';

describe('UptClienteComponent', () => {
  let component: UptClienteComponent;
  let fixture: ComponentFixture<UptClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UptClienteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UptClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
