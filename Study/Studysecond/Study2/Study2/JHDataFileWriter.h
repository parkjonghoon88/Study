//
//  JHDataFileWriter.h
//  Study2
//
//  Created by 박종훈 on 2016. 2. 3..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "JHDataWriter.h"
#import "JHStudent.h"

@interface JHDataFileWriter : NSObject<JHDataWriter>

-(instancetype) initWithFileName:(NSString*)fileName;


@end
