//
//  JHCommand2.h
//  Study2
//
//  Created by 박종훈 on 2016. 2. 9..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "JHStudent.h"

@protocol JHCommand <NSObject>

-(void)execute:(NSArray<JHStudent *>*) students;

@end
